package lib.json;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import lib.json.pojo.PfProd;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;

/**
 * <pre> Json, JSON相關實驗 </pre>
 *
 * @author Ian Chen
 */
public class Json {
  private static final Logger logger = LoggerFactory.getLogger(Json.class);
  private final String jsonString = "{\"prdNo\":\"bbb\",\"myJson\":{\"pfProdNo\":\"CTS05CI4907A\",\"vendNo\":\"VDR0000001883\",\"countryCd\":2}}";
  
  /**
   * 取出某一個結點
   * 使用JsonNode
   */
  @Test
  public void testGetFieldByJsonNode() throws JsonProcessingException, IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    JsonNode jn = objectMapper.readTree(jsonString);

    logger.info("{}", jn.get("myJson"));
    assertEquals("{\"pfProdNo\":\"CTS05CI4907A\",\"vendNo\":\"VDR0000001883\",\"countryCd\":2}", jn.get("myJson").toString());
  }
  
  /**
   * 取出某一個結點
   * 使用Map，底下的結點全都會變Map物件
   */
  @Test
  public void testGetFieldByMap() throws JsonParseException, JsonMappingException, IOException {
    String json = "{\"prdNo\":\"bbb\",\"myJson\":{\"pfProdNo\":\"CTS05CI4907A\",\"vendNo\":\"VDR0000001883\",\"countryCd\":2}}";
    ObjectMapper objectMapper = new ObjectMapper();
    Map<String, Object> jsonMap = new HashMap<String, Object>();

    // convert JSON string to Map
    jsonMap = objectMapper.readValue(json, new TypeReference<HashMap<String, Object>>() {});
    Object myJson = jsonMap.get("myJson");

    logger.info("{}", myJson);
  }
  
  /**
   * <pre>
   * 取出某一個結點
   * 使用POJO
   * </pre>
   */
  @Test
  public void testJsonToObject() throws JsonProcessingException, IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    PfProd pfProd = objectMapper.readValue(jsonString, new TypeReference<PfProd>() {});
    logger.info("{}", pfProd.getPrdNo());
  }

  /**
   * <pre>
   * 測試首字大寫屬性時會出錯
   * 改善方法
   * 1. 在POJO利用@JsonProperty指定屬性
   * 2. 修改json成小寫開頭
   * 
   * ps. 就算將POJO的欄位改成大寫開頭也沒有用，objectMapper仍會去找小寫開頭的屬性，找不到仍會報錯.
   * </pre>
   *
   * @throws JsonParseException
   * @throws JsonMappingException
   * @throws IOException
   */
  @Test(expected = UnrecognizedPropertyException.class)
  public void testJsonToObject大寫屬性() throws JsonParseException, JsonMappingException, IOException {
    final String jsonStringHasError =
        "{\"PrdNo\":\"bbb\",\"myJson\":{\"pfProdNo\":\"CTS05CI4907A\",\"vendNo\":\"VDR0000001883\",\"countryCd\":2}}";
    ObjectMapper objectMapper = new ObjectMapper();
    PfProd pfProd = objectMapper.readValue(jsonStringHasError, new TypeReference<PfProd>() {});
    logger.info("{}", pfProd.getPrdNo());
  }

  /**
   * 根據指定的型別轉換成物件
   * 
   * @throws JsonProcessingException
   * @throws IOException
   */
  @Test
  public void testJsonToSpecificObject() throws JsonProcessingException, IOException {
    PfProd pfProd = jsonToObject(jsonString, PfProd.class);
    logger.info("{}", pfProd.getPrdNo());
  }

  /**
   * 依型別使用ObjectMapper轉換成物件
   */
  private <E> E jsonToObject(String jsonString, Class<E> clazz) throws JsonParseException,
      JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    JavaType type = mapper.getTypeFactory().constructType(clazz);
    return mapper.readValue(jsonString, type);
  }
  
  @Test
  public void testJsonToHashMap() throws JsonProcessingException, IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    String jsonStr = "{\"windows\":\"C:\\\\opt\\\\APP\\\\aes\\\\\",\"mac\":\"/opt/APP/aes/\",\"linux\":\"/opt/APP/aes/\"}";
    HashMap pfProd = objectMapper.readValue(jsonStr, HashMap.class);
    logger.info("{}", pfProd);
  }
}

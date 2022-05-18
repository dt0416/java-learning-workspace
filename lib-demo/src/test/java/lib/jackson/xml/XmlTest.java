/**
 * 
 */
package lib.jackson.xml;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;


/**
 * @author 003542
 *
 */
public class XmlTest {

  @Test
  public void test() throws JsonMappingException, JsonProcessingException {
    // <?xml version='1.0' encoding='UTF-8'?><MERCHANTXML><MSGID>ORD0001</MSGID><CAVALUE>9accc18e6aba0097264d76eaf7c9154a</CAVALUE><ORDERINFO><STOREID>990231364</STOREID><ORDERNUMBER>9827120</ORDERNUMBER><AMOUNT>23150</AMOUNT></ORDERINFO></MERCHANTXML>
    String strRsXML = "<?xml version='1.0' encoding='UTF-8'?><CUBXML><CAVALUE>3d4900624144694bbe8648bdd703b0b1</CAVALUE><ORDERINFO><STOREID>990231364</STOREID><ORDERNUMBER>9827120</ORDERNUMBER><AMOUNT>23150</AMOUNT></ORDERINFO><AUTHINFO><AUTHSTATUS>0000</AUTHSTATUS><AUTHCODE>701745</AUTHCODE><AUTHTIME>20211101165445</AUTHTIME><AUTHMSG>授權成功</AUTHMSG><CARDNO>356580******9433</CARDNO></AUTHINFO></CUBXML>";
    XmlMapper xmlMapper = new XmlMapper();
    JsonNode jsonNode = xmlMapper .readValue(strRsXML, JsonNode.class);
    JsonNode orderinfo = jsonNode.get("ORDERINFO");
    String ordernumber = orderinfo.get("ORDERNUMBER").asText();
    JsonNode authinfo = jsonNode.get("AUTHINFO");
    String authstatus = authinfo.get("AUTHSTATUS").asText();
    String authcode = authinfo.get("AUTHCODE").asText();
    String authmsg = authinfo.get("AUTHMSG").asText();
    
    System.out.println(ordernumber);
    System.out.println(authstatus);
    System.out.println(authcode);
    System.out.println(authmsg);
  }

}

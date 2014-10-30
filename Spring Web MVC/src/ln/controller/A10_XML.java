package ln.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import ln.model.XmlPojo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * XML應用
 * 重點在返回的物件需加上『@XmlRootElemen』
 * 沒加會返回JSON有加就返回XML
 * 
 * @author Ian Chen
 */
@Controller
public class A10_XML {
  private static final Logger logger = Logger.getLogger(A10_XML.class.getName());

    /**
     * 取回Xml格式的XmlPojo物件
     */
    @RequestMapping(value="getXmlPojo")
    @ResponseBody
    public XmlPojo getXmlPojo() {
        return new XmlPojo("John", 18);
    }
    
    /**
     * 接收XML並返回新的XML
     * 測試url:http://localhost:8081/Spring_Web_MVC/receivePojoandGetNewPojoXml
     * body:<xMLpOJO><name>John</name><aGE>18</aGE></xMLpOJO>
     * Content-Type:application/xhtml+xml;charset=UTF-8
     */
    @RequestMapping(value="receivePojoandGetNewPojoXml", method = RequestMethod.POST)
    @ResponseBody
    public XmlPojo receiveJSONandGetNewUserJSON(@RequestBody XmlPojo xmlPojo) {
      long startTime = System.currentTimeMillis();
      XmlPojo result = new XmlPojo();
      result.setName("Hello " + xmlPojo.getName());
      result.setAge(xmlPojo.getAge());
      logger.log(Level.INFO, "performance(" + (System.currentTimeMillis() - startTime) + "ms)");
      return result;
    }
}

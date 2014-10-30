package ln.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <pre>
 * 使用JAXB的規範來產生xml
 * 使用的Annotation
 * -@XmlRootElement
 * 
 * -@XmlElement
 * 
 * -@XmlAccessorType : Configure Field or Property Access, see doc <a href="http://docs.oracle.com/javase/6/docs/api/javax/xml/bind/annotation/XmlAccessType.html">XmlAccessType</a>
 *  -@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER) // default, Every public getter/setter pair and every public field will be automatically bound to XML
 *  -@XmlAccessorType(XmlAccessType.PROPERTY) // Every getter/setter pair in a JAXB-bound class will be automatically bound to XML
 *  -@XmlAccessorType(XmlAccessType.FIELD) // Every non static, non transient field in a JAXB-bound class will be automatically bound to XML
 *  -@XmlAccessorType(XmlAccessType.NONE) // None of the fields or properties is bound to XML
 *  
 *  -@XmlType (propOrder={"prop1","prop2",..."propN"}) // 以java properties的方慣例命名, 不理會xml tag名稱
 *  
 * </pre>
 *
 * @author Ian Chen
 */
@XmlRootElement(name = "xMLpOJO")
//@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlType(propOrder={"name", "age"})
public class XmlPojo {
  private String name;
  private int age;

  public XmlPojo() { }

  public XmlPojo(String name, int age) {
    super();
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  @XmlElement(name = "aGE")
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
}

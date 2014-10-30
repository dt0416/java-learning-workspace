package ln.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 使用DefaultAnnotationHandlerMapping
 * 需在mvc-config.xml裡設置
 * <context:component-scan base-package="ln.controller"></context:component-scan>
 * <mvc:annotation-driven></mvc:annotation-driven>
 * 
 * 包含A02~A04
 * 
 * @author Ian Chen
 */
@Controller
public class A02_AnnotationHandlerMapping {

  /**
   * 透過@RequestMapping來對應url路徑，@RequestMapping的value也可以使用「regular expression」
   * 可設定多組url
   */
  @RequestMapping({"/annotationHandlerMapping", "/annotationHandlerMapping2"})
  public String annotationHandlerMapping() {
    return "A02_AnnotationHandlerMapping";
  }

  /**
   * url?參數取值
   * 當有設定@RequestParam的參數則一定要透過url傳值(一定要寫username=)，否則會出錯
   * 沒設定@RequestParam的參數則可傳可不傳值
   * 
   * context會自動傳給view
   * context也可使用Map，但建議使用Model
   */
  @RequestMapping({"/passValue", "applysitemesh/passValue"})
  public String passVaule(@RequestParam("username")String username, String age, Model context) {
    context.addAttribute("username", username);
    if (age == null) {
      age = "0";
    }
    context.addAttribute("age", Integer.parseInt(age)+1);
    // 使用單一參數，代表使用物件的Class第一字小寫當key，例:
    // context.addAttribute(username); = context.addAttribute("string", username);
    // context.addAttribute(new User()); = context.addAttribute("user", new User());
    return "A03_PassValue";
  }

  /**
   * 擷取url裡的參數(URI Template Patterns)
   * http://docs.spring.io/spring/docs/3.2.x/spring-framework-reference/html/mvc.html#mvc-ann-requestmapping-uri-templates
   * 例：@PathVariable String username = @PathVariable("username") String username
   */
  @RequestMapping("/{username}/passValueBetweenUrl")
  public String passValueBetweenUrl(@PathVariable String username, Model context) {
    context.addAttribute("username", "Hello " + username);
    return "A04_PassValueBetweenUrl";
  }
}

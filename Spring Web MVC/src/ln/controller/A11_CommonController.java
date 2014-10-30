package ln.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <pre>
 * 常見的Controller
 * </pre>
 *
 * @author Ian Chen
 */
@Controller
public class A11_CommonController {
  
  /**
   * 直接返回文字
   * 記得加上@ResponseBody
   */
  @RequestMapping(value="helloWithoutName", method = RequestMethod.GET)
  @ResponseBody
  public String helloWithoutName() {
    return "Hello World";
  }

  /**
   * 取得文字並返回文字
   * 記得加上@ResponseBody
   */
  @RequestMapping(value="helloWithName", method = RequestMethod.POST)
  @ResponseBody
  public String helloWithName(@RequestBody String name) {
    return "Hello " + name;
  }
}

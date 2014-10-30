package ln.controller;

import ln.model.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * JSON應用
 * 
 * @author Ian Chen
 */
@Controller
public class A09_JSON {

    /**
     * 取回JSON格式的User物件
     */
    @RequestMapping(value="getUserJSON")
    @ResponseBody
    public User getUserJSON() {
        return new User("John", "111", "jo", "jo@gmail.com");
    }
    
    /**
     * 接收JSON並返回新的JSON
     * 測試url:http://localhost:8081/Spring_Web_MVC/receiveJSONandGetNewUserJSON
     * body:{"userName":"John","password":"111","nickName":"jo","email":"jo@gmail.com"}
     * Content-Type:application/json;charset=UTF-8
     */
    @RequestMapping(value="receiveJSONandGetNewUserJSON", method = RequestMethod.POST)
    @ResponseBody
    public User receiveJSONandGetNewUserJSON(@RequestBody User user) {
      User result = new User();
      result.setUserName(user.getUserName());
      result.setNickName("Hello " + user.getNickName());
      result.setPassword(user.getPassword());
      result.setEmail(user.getEmail());
      return result;
    }
    
    /**
     * 接收JSON並返回新的JSON
     * 用ResponseEntity<T>取代@ResponseBody
     * 測試url:http://localhost:8081/Spring_Web_MVC/receiveJSONandGetNewUserJSON2
     * body:{"userName":"John","password":"111","nickName":"jo","email":"jo@gmail.com"}
     * Content-Type:application/json;charset=UTF-8
     */
    @RequestMapping(value="receiveJSONandGetNewUserJSON2", method = RequestMethod.POST)
    public ResponseEntity<User> receiveJSONandGetNewUserJSON2(@RequestBody User user) {
      User result = new User();
      result.setUserName(user.getUserName());
      result.setNickName("Hello2 " + user.getNickName());
      result.setPassword(user.getPassword());
      result.setEmail(user.getEmail());
      return new ResponseEntity<User>(result, HttpStatus.OK);
    }
}

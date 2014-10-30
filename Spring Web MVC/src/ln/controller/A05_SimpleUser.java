package ln.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import ln.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 簡單用戶管理:列表、增、刪、改、查
 * 使用Map模擬資料表
 * 
 * @author Ian Chen
 */
@Controller
@RequestMapping("/user")
public class A05_SimpleUser {
    private Map<String, User> users = new HashMap<String, User>();
    
    public A05_SimpleUser() {
        users.put("John", new User("John", "111", "jo", "jo@gmail.com"));
        users.put("Mary", new User("Mary", "222", "ma", "ma@gmail.com"));
        users.put("Bill", new User("Bill", "333", "bi", "bi@gmail.com"));
        users.put("Hello", new User("Hello", "444", "hi", "hi@gmail.com"));
    }
    
    /**
     * 至新增頁面
     */
    @RequestMapping(value="list")
    public String list(Model context) {
        context.addAttribute("users", users);
        return "user/list";
    }
    
    /**
     * 至新增頁面
     * 與goAdd1意思一樣
     */
    @RequestMapping(value = "goAdd", method = RequestMethod.GET)
    public String goAdd(Model context) {
        context.addAttribute(new User());
        return "user/goAdd";
    }
    
    @RequestMapping(value = "goAdd1", method = RequestMethod.GET)
    public String goAdd1(@ModelAttribute("user") User user) {
        return "user/goAdd";
    }
    
    /**
     * 新增用戶，成功後導至顯示用戶
     * 加上@Valid可以驗證資料，細節定義在User裡的Annotation
     * 此為使用JSR-303的規範
     * BindingResult一定要放在Valid屬性的後面
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/goAdd";
        }
        users.put(user.getUserName(), user);
        return "redirect:/user/list";
    }
    
    /**
     * 顯示單一用戶
     */
    @RequestMapping(value = "{userName}", method = RequestMethod.GET)
    public String showSingleUser(@PathVariable String userName, Model context) {
        context.addAttribute("user", users.get(userName));
        return "user/show";
    }
    
    /**
     * 至更新頁面
     */
    @RequestMapping(value = "{userName}/update", method = RequestMethod.GET)
    public String goUpdate(@PathVariable String userName, Model context) {
        context.addAttribute("user", users.get(userName));
        return "user/goUpdate";
    }
    
    /**
     * 更新用戶
     */
    @RequestMapping(value = "{userName}/update", method = RequestMethod.POST)
    public String update(@PathVariable String userName, @Valid User user, BindingResult bindingResult, Model context) {
        if (bindingResult.hasErrors()) {
            context.addAttribute("user", user);
            return "user/goUpdate";
        }
        users.put(userName, user);
        return "redirect:/user/list";
    }
    
    /**
     * 刪除用戶
     */
    @RequestMapping(value = "{userName}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable String userName, Model context) {
        users.remove(userName);
        return "redirect:/user/list";
    }
    
    /**
     * 將資料寫入session
     */
    @RequestMapping("{loginUser}/addSession")
    public String addSession(@PathVariable String loginUser, HttpSession session) {
        session.setAttribute("loginUser", loginUser);
        return "user/getSession";
    }
}

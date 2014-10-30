package ln.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * 使用BeanNameUrlHandlerMapping
 * 需繼承AbstractController
 * 缺點：畫面假如有多種操作(增刪改查)就不適合
 * 
 * @author Ian Chen
 */
public class A01_FirstController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest req,
            HttpServletResponse res) throws Exception {
        return new ModelAndView("A01_FirstMvc");
    }

}

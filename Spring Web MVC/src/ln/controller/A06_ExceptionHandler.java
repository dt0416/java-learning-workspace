package ln.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 例外處理範例
 * 
 * @author Ian Chen
 */
@Controller
public class A06_ExceptionHandler {

    /**
     * 單一controller例外擷取並導至錯誤頁面
     */
    @RequestMapping("exceptionHandle")
    public String exceptionHandle() {
        throw new RuntimeException("模擬單一例外");
    }
    
    /**
     * 全局例外處理，需在mvc-config.xml設定SimpleMappingExceptionResolver
     * 由於沒有被方法hadlerException擷取到就會被再往外丟至全局例外
     */
    @RequestMapping("throwGlobalException")
    public String throwException() throws Exception  {
        throw new Exception("模擬全局例外");
    }
    
    /**
     * catch到例外對應的處理
     * 此為搭配單一controller例外擷取並導至錯誤頁面的method
     * 缺點:只能處理此controller裡的異常
     */
    @ExceptionHandler(value=RuntimeException.class)
    public String hadlerException(Exception ex, HttpServletRequest req) {
        req.setAttribute("ex", ex);
        return "error";
    }
}

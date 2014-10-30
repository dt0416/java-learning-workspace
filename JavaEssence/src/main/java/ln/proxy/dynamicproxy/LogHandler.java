package ln.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.apache.log4j.Logger;

/**
 * 實作一個處理者實現動態代理
 * 可以使得一個處理者 (Handler)服務於各個物件
 * 處理者的類別必須實作InvocationHandler介面
 * 
 * @author Ian Chen
 */
public class LogHandler implements InvocationHandler {
    private static Logger logger = Logger.getLogger(LogHandler.class);
    private Object delegate;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        
        try {
            logger.info("method starts..." + method);
            
            result = method.invoke(delegate,  args);
            
            logger.info("method ends..." + method);
        } catch (Exception ex) {
            logger.error(ex);
        }
        return result;
    }
    
    public Object bind(Object delegate) {
        this.delegate = delegate; 
        return Proxy.newProxyInstance( 
                delegate.getClass().getClassLoader(), 
                delegate.getClass().getInterfaces(), 
                this); 
    }
}

package ln.proxy.staticproxy;

import org.apache.log4j.Logger;

import ln.proxy.IHello;
import ln.proxy.dynamicproxy.LogHandler;

/**
 * 靜態代理者(Proxy)
 * 一個代理者(Proxy)只能代理一個介面或類別
 * 
 * @author Ian Chen
 */
public class HelloProxy implements IHello {
    private static Logger logger = Logger.getLogger(HelloProxy.class);
    private IHello helloObject;
    
    public HelloProxy(IHello helloObject) {
        this.helloObject = helloObject;
    }

    @Override
    public void hello(String name) {
        logger.info("hello method starts....");
        
        helloObject.hello(name);
        
        logger.info("hello method ends....");
    }
}

package ln.proxy.dynamicproxy;

import static org.junit.Assert.*;
import ln.proxy.HelloSpeaker;
import ln.proxy.IHello;

import org.junit.Test;

/**
 * 使用J2SE實現動態代理
 * pros:寫一個Handler就能代理多種物件
 * 
 * @author Ian Chen
 */
public class A1_DynamicProxy {

    @Test
    public void testDynamicProxy() {
        LogHandler logHandler = new LogHandler();
        IHello helloProxy = (IHello) logHandler.bind(new HelloSpeaker());
        helloProxy.hello("Jordan");
    }
}

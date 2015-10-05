package ln.proxy.staticproxy;

import static org.junit.Assert.*;
import ln.proxy.HelloSpeaker;
import ln.proxy.IHello;

import org.junit.Test;

/**
 * 使用介面實作靜態代理
 * cons:一個代理者(Proxy)只能代理一種介面
 * 
 * @author Ian Chen
 */
public class A1_StaticProxy {

    @Test
    public void testStaticProxy() {
        IHello proxy = new HelloProxy(new HelloSpeaker());
        proxy.hello("Jordan");
    }
}

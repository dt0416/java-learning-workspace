package ln.reflection;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import ln.reflection.obj.MyObject;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * 利用MyObject
 * 呼叫static method、object method
 * 
 * @author Ian Chen
 */
public class A2_MethodInvoke {
    private static Logger logger = Logger.getLogger(A2_MethodInvoke.class);

    @Test
    public void test() {
        String className = "ln.reflection.obj.MyObject";
        try {
            Class clz = Class.forName(className);
            
            logger.info("static method");
            Method myStaticMethod = clz.getMethod("myStaticMethod", String.class);
            logger.info(myStaticMethod.invoke(clz, "test")); // 這裡丟Class即可
            
            logger.info("object method");
            Object myObject = clz.newInstance();
            Method setName = clz.getMethod("setName", String.class);
            Method getName = clz.getMethod("getName");
            setName.invoke(myObject, "methodInvoke"); // 這裡要丟Object
            logger.info(getName.invoke(myObject)); // 這裡要丟Object

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

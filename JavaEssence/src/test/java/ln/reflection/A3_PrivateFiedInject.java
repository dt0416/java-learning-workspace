package ln.reflection;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * <pre>
 * 利用反映存取物件裡的不同型態欄位
 * 包含public、protected、private、default
 * 因為有setAccessible(true)，變得不可思議
 * Spring的注入也利用此方式可以注入private欄位
 * 但也有安全性問題
 * <pre>
 * 
 * @author Ian Chen
 */
public class A3_PrivateFiedInject {
    private static Logger logger = Logger.getLogger(A2_MethodInvoke.class);

    @Test
    public void test() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String className = "ln.reflection.obj.PrivateFieldObject";
        Class<?> clz = Class.forName(className);
        Object myObject = clz.newInstance();
        Field[] fields = clz.getDeclaredFields();
        for (Field field : fields) {
            logger.debug(field);
            field.setAccessible(true); // 沒有這一行, 注入就需看目前物件和目標物件的關係來決定哪些是可存取的
            String fieldOriValue = (String) field.get(myObject);
            field.set(myObject, "Hello World!!");
            String fieldNewValue = (String) field.get(myObject);
            assertNotSame(fieldOriValue, fieldNewValue);
            logger.debug(field.getName() + "-NewValue:" + fieldNewValue);
        }
    }
}

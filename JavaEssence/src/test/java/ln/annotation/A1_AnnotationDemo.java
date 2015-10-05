package ln.annotation;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * 在myMethod上使用MyAnnotation
 * 並取得屬性值
 * 
 * @author Ian Chen
 */
public class A1_AnnotationDemo {
    private static Logger logger = Logger.getLogger(A1_AnnotationDemo.class);
    
    @Test
    public void test() {
        Method[] methods = this.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation ma = method.getAnnotation(MyAnnotation.class);
                String pro1 = ma.pro1();
                logger.info(pro1);
                assertEquals("str", pro1);
            }
        }
    }

    @MyAnnotation(pro1 = "str")
    public void myMethod() {
         
    }
}

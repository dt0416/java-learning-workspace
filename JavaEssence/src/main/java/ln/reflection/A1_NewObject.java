package ln.reflection;

import static org.junit.Assert.*;
import ln.reflection.obj.MyObject;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * 
 * 取得Class並初使化
 * 
 * Class.forName(className); = Class.forName(className, true, currentLoader);
 * 載入類別時就馬上執行靜態區塊
 * 
 * Class.forName(className2, false, Thread.currentThread().getContextClassLoader());
 * 載入類別時並『不會』馬上執行靜態區塊，而會在使用類別建立物件時 才去執行靜態區塊
 * 
 * @author Ian Chen
 */
public class A1_NewObject {
    private static Logger logger = Logger.getLogger(A1_NewObject.class);

    @Test
    public void test() {
        String className = "ln.reflection.obj.MyObject";
        String className2 = "ln.reflection.obj.MyObject2";
        try {
            logger.info("initial static");
            Class clz = Class.forName(className);
            logger.info("newInstance");
            Object myObject = clz.newInstance();
            
            logger.info("None initial static");
            Class clzNoStatic = Class.forName(className2, false, Thread.currentThread().getContextClassLoader());
            logger.info("newInstance");
            Object myObjectNoStatic = clzNoStatic.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

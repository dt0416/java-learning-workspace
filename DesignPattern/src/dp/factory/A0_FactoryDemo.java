package dp.factory;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.Test;

/**
 * 簡單工廠 + Properties
 * 
 * @author Ian Chen
 */
public class A0_FactoryDemo {

    @Test
    public void test() {
        Properties pro = new PropertiesOperate().getProperties() ;
        Fruit f = Factory.getInstance(pro.getProperty("fruit"));
        f.eat();
    }
}

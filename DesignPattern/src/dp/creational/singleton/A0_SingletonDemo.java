package dp.creational.singleton;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Singleton Demo
 * http://www.tutorialspoint.com/design_pattern/singleton_pattern.htm
 * 
 * @author Ian Chen
 */
public class A0_SingletonDemo {

    @Test
    public void test() {
        //illegal construct
        //Compile Time Error: The constructor SingleObject() is not visible
        //SingleObject object = new SingleObject();

        //Get the only object available
        SingleObject object = SingleObject.getInstance();

        //show the message
        object.showMessage();
    }

}

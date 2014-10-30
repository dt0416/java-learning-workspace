package dp.creational.prototype;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Prototype Demo
 * http://www.tutorialspoint.com/design_pattern/prototype_pattern.htm
 * 
 * @author Ian Chen
 */
public class A0_PrototypeDemo {

    @Test
    public void test() {
        ShapeCache.loadCache();

        Shape clonedShape = (Shape) ShapeCache.getShape("1");
        System.out.println("Shape : " + clonedShape.getType());       

        Shape clonedShape2 = (Shape) ShapeCache.getShape("2");
        System.out.println("Shape : " + clonedShape2.getType());      

        Shape clonedShape3 = (Shape) ShapeCache.getShape("3");
        System.out.println("Shape : " + clonedShape3.getType());
    }
}

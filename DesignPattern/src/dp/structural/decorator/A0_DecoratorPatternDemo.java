package dp.structural.decorator;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Decorator Demo
 * http://www.tutorialspoint.com/design_pattern/decorator_pattern.htm
 * 
 * @author Ian Chen
 */
public class A0_DecoratorPatternDemo {

  @Test
  public void test() {
    Shape circle = new Circle();

    Shape redCircle = new RedShapeDecorator(new Circle());

    Shape redRectangle = new RedShapeDecorator(new Rectangle());
    System.out.println("Circle with normal border");
    circle.draw();

    System.out.println("\nCircle of red border");
    redCircle.draw();

    System.out.println("\nRectangle of red border");
    redRectangle.draw();
  }
}

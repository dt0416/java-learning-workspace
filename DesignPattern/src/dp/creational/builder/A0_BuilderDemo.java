package dp.creational.builder;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Builder Demo
 * http://www.tutorialspoint.com/design_pattern/builder_pattern.htm
 * 
 * @author Ian Chen
 */
public class A0_BuilderDemo {

    @Test
    public void test() {
        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost: " +vegMeal.getCost());

        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("\n\nNon-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " +nonVegMeal.getCost());
    }
}

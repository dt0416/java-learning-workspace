package dp.creational.builder;

public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
       return new Wrapper();
    }
    
    public abstract float price();
}

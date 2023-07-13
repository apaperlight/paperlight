package CreatePattern;

public class FactoryPattern {
    public static void main(String[] args) {
        Fruit apple = new AppleFactory().createFruit();
        System.out.println(apple.name);
        Fruit banana = new BananaFactory().createFruit();
        System.out.println(banana.name);
    }
}
interface FruitFactory{
    Fruit createFruit();
}
class Fruit{
    public String name;
    Fruit(String fruit_name){
        name = fruit_name;
    }
}
class AppleFactory implements FruitFactory{
    @Override
    public Fruit createFruit() {
        return new Fruit("apple");
    }
}
class BananaFactory implements FruitFactory{
    @Override
    public Fruit createFruit() {
        return new Fruit("Banana");
    }
}
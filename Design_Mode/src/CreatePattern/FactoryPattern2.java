package CreatePattern;

import java.util.HashMap;
import java.util.Map;
//使用这种方式创建可以直接通过类名.方法进行创建，但是如果添加了新的具体工厂需要修改构造者类，所以也并不符合开闭原则
public class FactoryPattern2 {
    public static void main(String[] args) {
        //如果想要使用工厂类名来进行创建，有多种实现方式
        Fruit apple = FruitDirector.createFruit("apple");
        if(apple != null) System.out.println(apple.name);
        Fruit banana = FruitDirector.createFruit("banana");
        if(banana != null) System.out.println(banana.name);
    }
}
//自己选择调用哪个工厂，有点像构建者模式
class FruitDirector{
    private static final Map<String,FruitFactory> director = new HashMap<>();
    static {
        director.put("apple",new AppleFactory());
        director.put("banana",new BananaFactory());
    }
    public static Fruit createFruit(String fruit_name){
        FruitFactory factory = director.get(fruit_name);
        if(factory != null){
            return factory.createFruit();
        }
        return null;
    }
}
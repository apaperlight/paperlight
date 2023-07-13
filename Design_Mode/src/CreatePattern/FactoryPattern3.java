package CreatePattern;
/*     采用反射来进行创建，这样就可以不用进行手动添加了.
       但这其实也属于构造者模式，因为是传进去东西选择哪个工厂创建
       如果想要改变的话，可能就是去寻找Fruit，然后返回Fruit才对。
 */
public class FactoryPattern3 {
    public static void main(String[] args) throws Exception {
        Fruit apple = FruitDirector2.createFruit("Apple");
        System.out.println(apple.name);
    }
}
class FruitDirector2{
    public static Fruit createFruit(String fruit_name) throws Exception {
        Class<?> cls = Class.forName("CreatePattern." + fruit_name + "Factory");
        FruitFactory factory = (FruitFactory) cls.getDeclaredConstructor().newInstance();
        return factory.createFruit();
    }
}
package test_abstract;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: 抽象类存在的意义就是为子类提供统一，规范的模板子类必须实现相关的抽象方法
 * @Version: 1.0
 */
public abstract class testAbstract {

    public static void main(String[] args) {
        Dog dog =new Dog();
        //Animal a =new Animal();是错误的
        dog.shout();
        dog.run();
    }
}
//特点：没有实现,子类必须实现 抽象类不能new实现实例化，
// 只能被子类来调用，有抽象方法的类只能被定义为抽象类
abstract class Animal{//父类抽象类
    abstract public void shout();
    public void run(){
        System.out.println("跑");
    }
}
class Dog extends Animal{//子类
    @Override//只能被重写
    public void shout() {
        System.out.println("汪汪汪");
    }
}

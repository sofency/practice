package test_poly;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: 测试多态
 * @Version: 1.0
 */
public class test_poly {
    public static void main(String[] args) {

        Animal a = new Animal();
        animalCry(a);

        Animal x=new Cat();//自动向上转型，从狗类转化为动物类，刚开始式程序会以为它是个Animal类，只有在运行时才会鉴别出来它是个Dog类
        x.shout();//会自动匹配后面的对象属于哪个方法
//        x.play();//编译器不认识x是什么类的所以无法调用
        Cat c= (Cat) x;//强制向下转型  强制把Animal类型的x转化为Cat类
//        此时可以调用Cat的类
        c.play();

        Dog d = new Dog();
        animalCry(d);
        //强制把猫转化为狗

//        Dog dog=(Dog) x;//编译不会出错，但是运行会出错误的
    }
    static void animalCry(Animal a){//父类引用子类对象
        a.shout();
    }
}

class Animal{
    public void shout(){
        System.out.println("叫了一声");
    }
}

class Dog extends Animal{//继承重写
    public void shout(){
        System.out.println("旺旺旺!");
    }
}

class Cat extends Animal{
    public void shout(){
        System.out.println("喵喵喵~~~");
    }
    public void play(){
        System.out.println("我又叫了一次");
    }
}

package top.sofency.testSuper;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: top.sofency.testSuper
 * @Version: 1.0
 */
public class testSuper {
    public static void main(String[] args) {
        ChildClass c=new ChildClass();
        c.f();
        System.out.println(c.value);
    }

}
class FatherClass{
    public int value;
    public void f(){
        value=100;
        System.out.println("FatherClass.value="+value);
    }
}
class ChildClass extends FatherClass{
    public int value;
    public void f(){
        super.f();//调用父类对象的普通方法
        value=200;
        System.out.println("ChildClass.value="+value);
        System.out.println(value);
        System.out.println(super.value);//调用父类，就是子类继承父类的属性
    }
}
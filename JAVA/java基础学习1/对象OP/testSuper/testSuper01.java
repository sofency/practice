package top.sofency.testSuper;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: top.sofency.testSuper
 * @Version: 1.0
 */
public class testSuper01 {
    public static void main(String[] args){
        System.out.println("开始创建一个对象....");
        ChildClass1 c=new ChildClass1();
    }
}
class FatherClass1{
    public FatherClass1(){
        System.out.println("创建1");
    }
}
class ChildClass1 extends FatherClass1{
    public ChildClass1(){//super位于构造器的第一句，构造方法
        System.out.println("创建2");
    }
}
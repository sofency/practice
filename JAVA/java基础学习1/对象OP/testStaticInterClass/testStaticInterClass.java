package testStaticInterClass;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: 测试静态内部类
 * @Version: 1.0
 */
public class testStaticInterClass {
    public static void main(String[] args) {
        Outer2 out=new Outer2();
        out.testOut();//访问外部类里面的age

        Outer2.Inter2 inter2=new Outer2.Inter2();//创建静态类的方法
        inter2.show();
        System.out.println(inter2.age);
    }
}
class Outer2{
    private int age=20;

    public void testOut(){//外部类的方法
        System.out.println(age);
    }

    static class Inter2{//非静态内部类
        int age=30;
        public void show(){
            int age=40;
            //System.out.println("访问外部类变量"+ );//暂定无法访问外部类变量及方法
            //可以写Outer.this.age 表示内部类可以使用的话外部类必然存在
            System.out.println("访问内部类变量"+this.age);
            System.out.println("访问内部类方法的变量"+age);
        }
    }
}
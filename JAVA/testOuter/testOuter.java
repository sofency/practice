package testOuter;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: 测试非静态内部类
 * @Version: 1.0
 */

/**
 * 非静态内部类
 * 1.非静态内部类必须寄存在一个外部类对象中，因此如果有一个非静态类对象那么一定存在对应的外部类对象，非静态内部类单独属于外部类的某个对象
 * 2.非静态内部类可以直接访问外部类的成员，但是外部类不能直接访问非静态内部类成员
 * 3.非静态内部类不能有静态方法，静态属性,静态初始化块
 * 4.外部类的静态方法，静态代码块不能访问非静态内部类，包括不能使用非静态内部类定义变量，创建实例。
 */

/**
 * 成员变量访问要点：
 * 1.内部类方法的局部变量 :变量名
 * 2.内部类属性:this.变量名
 * 3.外部类属性:外部类名.this.变量名
 */

public class testOuter {
    public static void main(String[] args) {
        //创建内部类对象的方法
        Outer.Inter inter=new Outer().new Inter();
        //需要先创建外部类再进行创建内部类，内部类创建之后外部类必然存在
        inter.show();
    }


}

class Outer{
    private int age=20;

    public void testOut(){//外部类的方法

    }

    class Inter{//非静态内部类
        int age=30;
        public void show(){
            int age=40;
            System.out.println("访问外部类变量"+Outer.this.age);//访问外部类变量
            //可以写Outer.this.age 表示内部类可以使用的话外部类必然存在
            System.out.println("访问内部类变量"+this.age);
            System.out.println("访问内部类方法的变量"+age);
        }
    }
}
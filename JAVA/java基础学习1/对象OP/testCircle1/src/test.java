/**
 * @Auther :sofency
 * @Date: ${2019/3/22}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
public class test {
    public static void main(String[] args) {

        //Circle1.radius=3;这样修改后不会对其他类的引用有影响并且这样修改后 radius必须是静态的
        Circle1 circle1= new Circle1();//定义对象 引用 2 函数
        System.out.println("The area of the circle of radius "+circle1.radius+" is "+circle1.getArea());

       Circle1 circle2=new Circle1(25);//引用3函数
        System.out.println("The area of the circle of radius "+circle2.radius+" is "+circle2.getArea());

        Circle1 circle3=new Circle1(125);// 引用 3 函数
        System.out.println("The area of the circle of radius "+circle3.radius+" is "+circle3.getArea());

        circle2.radius=100;// 引用 1 函数
        System.out.println("The area of the cirlce of radius "+circle2.radius+" is "+circle2.getArea());

    }
    //创建circle类
    static class Circle1{
        /*当成员被static修饰之后，就多了一种访问方式，除了可以被对象调用之外，还可以直接被类名调用，(类名.静态成员);
        * 即下面的这句话可以写成 static double radius  然后在主类中通过 Circle1.radius进行调用*/
        double radius;//1
        Circle1(){
            radius=1.0;//2
        }
        Circle1(double newRadius){//函数的重载
            radius=newRadius;//3
        }
        double getArea(){//返回面积
            return radius*radius*Math.PI;
        }
    }
}

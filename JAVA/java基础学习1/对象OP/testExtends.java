package top.sofency;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: top.sofency
 * @Version: 1.0
 */
public class testExtends {
    public static void main(String[] args) {

        student stu1=new student();//空的对象

        student stu=new student("sofency",185,"software");//构造学生的对象
        stu.rest();//能调用父亲的方法(构造方法除外)？

        //System.out.println(stu.pwd);//pwd是父亲私有的属性不可访问
        //Person p1=new Person();
        //System.out.println(Person.pwd);pwd是父亲私有的无法访问

        System.out.println(stu.name+","+stu.height+","+stu.major);
        System.out.println(stu instanceof student);//用instanceof 判断对象是否属于某一个类
        System.out.println(stu instanceof Person);
        System.out.println(stu instanceof Object);
    }
}
class Person{
    String name;
    int height;

    private String pwd="123";//是父类的小秘密无法访问到
    public void rest(){
        System.out.println("休息一会！");
    }
}

/*class Student{
    String name;
    int height;//这样重复了person里面的属性，所以可以用继承的方法进行将属性继承到现在的方法中
    String major;

    public void study(){
        System.out.println("学习两小时!");
    }
}*/
class student extends Person{
    String major;

    public void study(){
        System.out.println("学习两小时!");
    }
    public student(String name,int height,String major){
        this.name=name;
        this.height=height;
        this.major=major;
    }
    public student(){
    }
}
//java是单继承，只有一个直接父类，idea用Ctrl+h查找类的继承关系
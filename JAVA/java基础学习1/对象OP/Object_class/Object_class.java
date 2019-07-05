package Object_class;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: Object_class
 * @Version: 1.0
 */
//学习Object类，并且学习其中的toString类
public class Object_class {
    public static void main(String[] args) {
        Object_class to =new Object_class();
        System.out.println(to.toString());//因为Object_class继承了Object里面的toString类

        Person p1=new Person("sofency",18);
        System.out.println(p1.toString());//对于toString的重写
    }
    //overwrite
    public String toString(){
        return "hello world";
    }
}
class Person{
    String name;
    int age;

    //overwrite
    public String toString(){
        return name+"的年龄是"+age;
    }
    public  Person(String name,int age){
        this.name=name;
        this.age=age;//this从属与对象
    }
}

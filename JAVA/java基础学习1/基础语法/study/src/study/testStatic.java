package study;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: testStatic
 * @Version: 1.0
 */
import java.util.Scanner;
public class testStatic {
    int id;
    String name;
    String pwd;//以上三个普通变量从属于对象 意思是可以通过new一个对象后开始使用

    static String company="北京尚学堂";//static修饰的变量从属于类

    public testStatic(int id,String name){//从属于对象
        this.id=id;
        this.name=name;
    }

    public void login(){
        //能调用静态方法
        login();
        System.out.println("登录: "+name);
        //能调用静态变量
        System.out.println("公司: "+company);
    }

    public static void printCompany(){//静态方法
        //login()调用非静态变量 编译就会报错
        //login();//在静态方法中无法调用login函数
        System.out.println(company);
    }
    public static void main(String[] args) {
        testStatic user=new testStatic(110,"sofency");
        user.printCompany();//通过对象调用printCompany函数
        user.login();//对象可以调用
        testStatic.printCompany();//通过类调用printCompany 函数
        //testStatic.login();类不可以调用
        System.out.println();
        user.company="锋火";
        //login();无法使用非静态方法不在一个区，无法找到位置
        user.printCompany();
        testStatic.printCompany();
    }
}

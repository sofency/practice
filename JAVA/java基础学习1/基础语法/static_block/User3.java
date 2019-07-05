package static_block;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: static_block
 * @Version: 1.0
 */
// 理解 在程序的运行时,会将类进行初始化,并将类初始化之后的结果打印出来。

public class User3 {
    int id;//id
    String name;//名字
    String pwd;//密码

    static String company;//公司名称

    static {//执行类的初始化
        System.out.println("执行类的初始化");
        company="Sofency";
        printCompany();
    }

    public static void printCompany(){//在方法块中
        System.out.println(company);
    }

    public static void main(String[] args){
        User3 user=null;//尽管没有分配对象但是还是执行了static块中的程序 这就是块的初始化
        //上面语句不写static代码块也会执行
    }
}

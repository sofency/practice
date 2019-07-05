/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
public class test1 {
    public static void main(String[] args) {
        Examples One= new Examples();
        Examples Two=new Examples();

        Examples.country="China";
        //Examples.name="小明";无法使用 类不能访问到非静态变量
        One.name="小明";
        Two.name="小花";

        Examples.print();
        //Examples.print1();无法使用
        One.print1();
        Two.print1();
        //说明类的调用要写static进行修饰
    }

}

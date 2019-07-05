/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
public class TestAutoBox {
    public static void main(String[] args) {
        Integer a=234;//编译器内部是通过Integer a=Integer.value(234);实现自动装箱

        int b=a;//自动拆箱   int b=a.intValue();
        int m=10;
        int n=10;//他们两个都在常量池里面 所以m==n是正确的  对象一样

        System.out.println(m==n);

        Integer e=Integer.valueOf(11);
        Integer f=11;
        System.out.println(e==f);//当数据在-128--127之间时不重新创建对象


        Integer e1=1111;
        Integer f1=1111;//当数据不在-128--127之间时重新创建对象
        System.out.println(e1==f1);
    }
}

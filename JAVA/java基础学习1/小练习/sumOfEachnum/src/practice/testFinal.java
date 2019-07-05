package practice;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: 测试final的用法
 * @Version: 1.0
 */
public class testFinal {
    public static void main(String[] args) {
        int sum=20;//20是常量 sum是变量
        sum=30;//sum是可变的所以是变量
        //如何将sum也变成常量,加上修饰符final
        final int num=40;
        //num=30;会报错
    }
}

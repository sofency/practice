package StringClass;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: StringClass
 * @Version: 1.0
 */
public class test_lenth {
    public static void main(String[] args) {
        //测试字符串
        String s1="Welcome to JAVA";
        String s2=" and python 大讲堂";

        System.out.println(s1.length());//返回s1的长度
        System.out.println(s1.charAt(3));//输入数字的下标返回字符
        System.out.println(s1.concat(s2));//将s1和s2连接起来
    }
}

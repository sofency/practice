package StringClass;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: StringClass
 * @Version: 1.0
 */
public class test_compareTo {
    public static void main(String[] args) {
        String s1="Welcome to China";
        String s2="hello world";
        String s3="Welcome to China";
        System.out.println(s1.compareTo(s2));// W-h= -17根据在ascii上面的排序根据首字母进行比较的
        System.out.println(s1.compareTo(s3));
        System.out.println(s2.compareTo(s3));//h-W =17
        System.out.println('W'-'h');
    }

}

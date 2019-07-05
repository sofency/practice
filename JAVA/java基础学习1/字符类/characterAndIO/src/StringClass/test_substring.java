package StringClass;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: StringClass
 * @Version: 1.0
 */
public class test_substring {
    public static void main(String[] args) {
        //获取字串
        String s1="Welcome to China and study JAVA";
        System.out.println(s1.substring(0,16));//范围是startindex =< string < endindex
        String message="hello world".substring(0,5);//可以用字符串进行操作
        System.out.println(message);
    }
}

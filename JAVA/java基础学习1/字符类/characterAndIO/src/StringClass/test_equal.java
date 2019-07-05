package StringClass;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: StringClass
 * @Version: 1.0
 */
public class test_equal {
    public static void main(String[] args) {
        String s1="Welcome to China";
        String s2="Welcome to China";
        //用equal判断s1和s2相等
        if(s1.equals(s2)){
            System.out.println("the two String is equal");
        }
        else{
            System.out.println("the two String is not equal");
        }
    }
}

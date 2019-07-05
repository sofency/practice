/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
public class stringBuilder {
    public static void main(String[] args) {
        String  str="hello world";
        System.out.println(str.hashCode());
        String str1=str.substring(1,4);
        System.out.println(str1);
        System.out.println(str);//字符串不可变

        StringBuilder str2=new StringBuilder("absjsjoaosk");//StringBuilder修饰的是可变字符串
        //即进行的操作是在原字符串上面进行的
        System.out.println(str2.hashCode());
        str2.setCharAt(1,'B');//修改原来的字符串
        System.out.println(str2);
        System.out.println(str2.hashCode());
    }
}

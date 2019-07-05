/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
import java.util.Scanner;
public class ignoreNonumAndNoChar {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String string=new String();
        string=input.nextLine();
        System.out.println(isPalind(string));
    }

    public static boolean isPalind(String s){
        String s1=fliter(s);
        String s2=reverse(s1);
        return s1.equals(s2);
    }
    public static String fliter(String s){
        StringBuilder str=new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(Character.isLetterOrDigit(s.charAt(i))){
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }
    public static String reverse(String s){
        StringBuilder str=new StringBuilder(s);
        str.reverse();
        return str.toString();
    }
}

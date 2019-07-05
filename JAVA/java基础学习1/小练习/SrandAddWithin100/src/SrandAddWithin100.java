/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
import java.util.Scanner;
public class SrandAddWithin100 {
    public static void main(String[] args) {
        int number1=(int)(System.currentTimeMillis()%100);
        int number2=(int)(System.currentTimeMillis()*6%100);
        Scanner input = new  Scanner(System.in);
        System.out.println("what is "+ number1+" + "+number2+"?");
        int answer=input.nextInt();
        if(answer==number1+number2)
        {
            System.out.println("well done,you are right");
        }
        else
        {
            int Answer=number1+number2;
            System.out.println("the right answer is"+Answer);
        }
    }
}

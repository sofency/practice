package practice; /**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
import java.util.Scanner;
public class lottery {
    public static void main(String[] args) {
        int lottery=(int)(Math.random()*100);
        Scanner input =new Scanner(System.in);
        System.out.print("Enter your practice.lottery pick(two digits): ");
        int guess=input.nextInt();
        int lotteryDigit1=lottery/10;
        int lotteryDigit2=lottery%10;

        int guessDigit1=guess/10;
        int guessDigit2=guess%10;

        System.out.println("The practice.lottery number is "+lottery);

        if(guess==lottery){
            System.out.println("Exact match: you win $10000");
        }
        else if (guessDigit1==lotteryDigit2&&guessDigit2==lotteryDigit1){
            System.out.println("Match all number,you win $3000");
        }
        else if(guessDigit1==lotteryDigit1||
                guessDigit1==lotteryDigit2||
                guessDigit2==lotteryDigit1||
                guessDigit2==lotteryDigit2){
            System.out.println("Match one digit: you win $1000");
        }
        else
            System.out.println("Sorry,no match");
    }
}

package package3;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: package3
 * @Version: 1.0
 */
import java.util.Scanner;
public class LottoNumbers {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        boolean[] isCovered=new boolean[99];
        int number =input.nextInt();
        while (number!=0){
            isCovered[number-1]=true;
            number=input.nextInt();
        }
         boolean allCovered=true;
        for (int i = 0; i < 99; i++) {
            if(!isCovered[i]){
                allCovered=false;
                break;
            }
        }
        if(allCovered){
            System.out.println("the tickets cover all numbers");
        }
        else{
            System.out.println("the tickets don't cover all numbers");
        }
    }
}

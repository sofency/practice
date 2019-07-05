/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
import javax.swing.plaf.synth.SynthInternalFrameUI;
import java.util.Scanner;
public class huiwen {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter an integer:");
        int number=input.nextInt();
        if(judge(number)){
            System.out.println(number+" is a palindrome");
        } else {
            System.out.println(number+" is a palindrome");
        }
    }
    public static boolean judge(int num){
        int[] arr=new int[100];
        int cnt=0;
        while(num!=0) {
            arr[cnt++]=num%10;
            num=num/10;
        }
        for(int i=0;i<cnt/2;i++) {
            if(arr[i]!=arr[cnt-i-1]) {
                return false;
            }
        }
        return true;
    }
}

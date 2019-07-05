/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
import java.util.Scanner;
public class factorial {
    public static void main(String[] args) {
        final int max = 1000;//宏定义
        int digit = 1;
        int[] array = new int[max];//定义数组
        array[0] = 1;
        Scanner input = new Scanner(System.in);
        int numOfFact = input.nextInt();//获取阶乘的最大乘数
        for (int i = 2; i <= numOfFact; i++) {
            int num = 0;
            for (int j = 0; j < digit; j++) {
                int temp = array[j] * i + num;
                array[j] = temp % 10;
                num = temp / 10;
            }
            while (num != 0) {
                array[digit] = num % 10;//继续储存
                num = num / 10;
                digit++;
            }
        }
        int cnt = 0;
        for (int i = digit-1; i>=0; i--) {
            System.out.print(array[i]);
        }
    }
}


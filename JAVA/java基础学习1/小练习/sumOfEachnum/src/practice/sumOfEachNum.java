package practice; /**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
import javax.swing.JOptionPane;
public class sumOfEachNum {
    public static void main(String[] args) {
        String number=JOptionPane.showInputDialog("请输入数字：");
        long num=Long.parseLong(number);
        int sum=sumDigits(num);
        JOptionPane.showMessageDialog(null,"the sum of each digits is "+sum);
    }
    public static int sumDigits(long n){
        long[] list=new long[100];
        int sum=0;
        while(n!=0){
            sum+=n%10;
            n=n/10;
        }
        return sum;
    }
}

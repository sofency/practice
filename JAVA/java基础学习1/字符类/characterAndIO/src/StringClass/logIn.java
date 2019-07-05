package StringClass;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: StringClass
 * @Version: 1.0
 */
import javax.swing.JOptionPane;
public class logIn {
    public static void main(String[] args) {
        String Account="3279";
        String Password="1918";
        while(true)
        {
            String showAccount=JOptionPane.showInputDialog("请输入登陆账号");
            double account=Double.parseDouble(showAccount);
            String strAccount = ""+account;//转化为字符串

            String showPassword=JOptionPane.showInputDialog("请输入登陆密码");
            double password=Double.parseDouble(showPassword);
            String strPassword = ""+password;//转化为字符串

            if((strAccount.compareTo(Account)==0)&&(strPassword.compareTo(Password)==0)){
                JOptionPane.showMessageDialog(null,"Exact match");
                break;
            }
            else{
                JOptionPane.showMessageDialog(null,"sorry the account or password may wrong,please type again");
            }
        }

    }
}

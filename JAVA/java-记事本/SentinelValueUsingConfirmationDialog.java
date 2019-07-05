import javax.swing.JOptionPane;

public class SentinelValueUsingConfirmationDialog{
	public static void main(String[] args){
		int sum=0;
		
		int option=JOptionPane.YES_OPTION;
		while(option==JOptionPane.YES_OPTION)
		{
			String  dataString=JOptionPane.showInputDialog("Enter an int number");
			int data=Integer.parseInt(dataString);
			sum+=data;
			option=JOptionPane.showConfirmDialog(null,"Continue?");//给出确认对话框让用户决定是否输入
		}
		JOptionPane.showMessageDialog(null,"the sum is "+sum);
	}
}
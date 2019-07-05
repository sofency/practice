import java.util.Scanner;
import javax.swing.JOptionPane;
public class ComputeChange{
	public static void main(String [] args){
		String money =JOptionPane.showInputDialog("Enter an amount in double,for example 11.56: ");
		double input=Double.parseDouble(money);
                double amount=input;
		
		
		int remainingAmount=(int)(amount * 100);
		//get dollars
		int numberOfOneDollars=remainingAmount/100;
		remainingAmount=remainingAmount%100;
		//get Quarters
		int numberOfQuarters=remainingAmount/25;
		remainingAmount=remainingAmount%25;
		//get Dimes
		int numberOfDimes=remainingAmount/10;
		remainingAmount=remainingAmount%10;
		//get Nickels
		int numberOfNickels=remainingAmount/5;
		remainingAmount=remainingAmount%5;
		//get pennies
		int numberOfPennies=remainingAmount;
		
		String output="your amount " + input + " consists of \n"+ "\t" +numberOfOneDollars + "dollars\n" +
		"\t" + numberOfQuarters + "quarters\n" +
		"\t" + numberOfDimes + "dimes\n" +
		"\t" + numberOfNickels + "nickels\n" +
		"\t" + numberOfPennies + "pennies";
		JOptionPane.showMessageDialog(null,output);
	}
}
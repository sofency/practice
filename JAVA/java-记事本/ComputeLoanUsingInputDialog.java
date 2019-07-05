import javax.swing.JOptionPane;
public class ComputeLoanUsingInputDialog{
	public static void main(String[] args){
		//Enter yearly interest rate
		String annualInterestRateString=JOptionPane.showInputDialog(
		"Enter yearly interest rate,from example 8.25:");
		double annualInterestRate=Double.parseDouble(annualInterestRateString);
		//convert string to double
		double monthlyInterestRate=annualInterestRate/1200;
		//Enter number of years
		String numberOfYearString=JOptionPane.showInputDialog(
		"Enter number of years as an integer,\n for example 5:");
		//Convert string to int
		int numberOfYears = Integer.parseInt(numberOfYearString);
		//enter loan amount
		String loanString=JOptionPane.showInputDialog(
		"Enter loan amount,for example 150000:");
		//convert string to double
		double loanAmount=Double.parseDouble(loanString);
		//calculate payment
		double monthlyPayment=loanAmount * monthlyInterestRate /(
		1 - 1/Math.pow(1 + monthlyInterestRate,numberOfYears * 12));
		double totalPayment = monthlyPayment * numberOfYears * 12;
		
		monthlyPayment=(int)(monthlyPayment*100)/100.0;
		totalPayment=(int)(totalPayment*100)/100.0;
		//display results
		String output="The monthly payment is " + monthlyPayment + "\nThe total payment is " +totalPayment;
     	JOptionPane.showMessageDialog(null,output);
	}
}	
		
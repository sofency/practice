import java.util.Scanner;
import javax.swing.JOptionPane;
public class ComputeAverage{
   public static void main(String[] args){
	String numberSize=JOptionPane.showInputDialog("Enter the number size");
	int size=Integer.parseInt(numberSize);
	int count=0;
	double sum=0;
	double[] numbers=new double[size];
	while(count<size)
	{
		String numberOfSize=JOptionPane.showInputDialog("Enter the number "+count);
		numbers[count]=Double.parseDouble(numberOfSize);
		sum+=numbers[count];
                count++;
	}
    
    double average=sum/size;
    String output="The average of these numbers is "+average;
	JOptionPane.showMessageDialog(null,output);
  }
}

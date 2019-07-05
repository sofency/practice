import java.util.Scanner;
import javax.swing.JOptionPane;
public class GuessNumber{
	public static void main(String[] args){
		int number =(int)(Math.random()*101);
		String printInDialog="Guess a magic number between 0 and 100";
		JOptionPane.showMessageDialog(null,printInDialog);
		
		int guess=-1;
                int count=0;
		while(guess!=number)
		{
			String GuessNumberOne=JOptionPane.showInputDialog("Enter your guess number");
			guess=Integer.parseInt(GuessNumberOne);
			if(guess==number)
			{
				String GuessRight="your guess is right! you have spent "+count+" time guessing the right number";
				JOptionPane.showMessageDialog(null,GuessRight);
			}
			else if(guess>number)
			{
				String GuessHigh="your guess is high";
				JOptionPane.showMessageDialog(null,GuessHigh);
			}
			else
			{
				String GuessLow="your guess is low";
				JOptionPane.showMessageDialog(null,GuessLow);
			}
                       count++;
		}
	}
}
		
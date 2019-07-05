import java.util.Scanner;
import javax.swing.JOptionPane;
public class SubtractionQuiz{
	public static void main(String[] args){
		int correctcount=0;//正确的计数器
		int count=0;//计数器
		final int NUMBER_OF_QUESTIONS=5;//设置计算的个数
		long startTime=System.currentTimeMillis();//获取当前时间
		String output="";
		
		while(count<NUMBER_OF_QUESTIONS)
		{
			int number1=(int)(Math.random()*100);
			int number2=(int)(Math.random()*100);
			if(number1<number2){//交换
				int temp=number1;
				number1=number2;
				number2=temp;
			}
			
			String SubtractionLoop = JOptionPane.showInputDialog(null,"What is "+number1+" - "+number2+" = ");//对话框上面的字符串
			int Subtraction = Integer.parseInt(SubtractionLoop);//获取输入到对话框里面的整型数据
			
			
			count++;
			output+="\n"+number1 + " - " +number2+ " = "+Subtraction+((number1-number2==Subtraction)?"correct":"wrong");
		}
		long endTime = System.currentTimeMillis();
		long testTime = endTime - startTime;
		
		String printanswer = "Test time is "+testTime/1000+" seconds\n"+output;
		JOptionPane.showMessageDialog(null,printanswer);
	}
}
			
import java.util.Scanner;
import javax.swing.JOptionPane;
public class SubtractionQuiz{
	public static void main(String[] args){
		int correctcount=0;//��ȷ�ļ�����
		int count=0;//������
		final int NUMBER_OF_QUESTIONS=5;//���ü���ĸ���
		long startTime=System.currentTimeMillis();//��ȡ��ǰʱ��
		String output="";
		
		while(count<NUMBER_OF_QUESTIONS)
		{
			int number1=(int)(Math.random()*100);
			int number2=(int)(Math.random()*100);
			if(number1<number2){//����
				int temp=number1;
				number1=number2;
				number2=temp;
			}
			
			String SubtractionLoop = JOptionPane.showInputDialog(null,"What is "+number1+" - "+number2+" = ");//�Ի���������ַ���
			int Subtraction = Integer.parseInt(SubtractionLoop);//��ȡ���뵽�Ի����������������
			
			
			count++;
			output+="\n"+number1 + " - " +number2+ " = "+Subtraction+((number1-number2==Subtraction)?"correct":"wrong");
		}
		long endTime = System.currentTimeMillis();
		long testTime = endTime - startTime;
		
		String printanswer = "Test time is "+testTime/1000+" seconds\n"+output;
		JOptionPane.showMessageDialog(null,printanswer);
	}
}
			
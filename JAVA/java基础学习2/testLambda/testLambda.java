package testLambda;

import java.awt.Toolkit;
import java.util.Arrays;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;
public class testLambda {
	public static void main(String[] args) {
		String[] plants=new String[] {"Mercury","Venus","Earth","Mars","Jupiter","Saturn"};
		System.out.println(Arrays.toString(plants));//����ַ���
		
		//����ĸ��˳������
		Arrays.sort(plants);
		System.out.println(Arrays.toString(plants));
		//ʹ�������������ݳ��Ƚ�������
		
		Arrays.sort(plants,(first,second)->first.length()-second.length());
		System.out.println(Arrays.toString(plants));
		
		Timer t=new Timer(1000, event->{//event��listenerѭ��������ʱ��
			System.out.println("the time is "+new Date()); 
			Toolkit.getDefaultToolkit().beep();
		});
		t.start();
		JOptionPane.showMessageDialog(null, "Quit programs?");
		System.exit(0);
		
		//int y=(x,m)->x+m;//Ŀ�����͵ı�������һ�������ӿ�
		//System.out.println(y);
		
		
		//�ܽ������������ŵ�  ����Ҫһ�����ܵ�ʱ��û�б�Ҫ��дһ�����ܺ���  Ȼ��new���� Ȼ�󴫽�����  
		//����ĺ����Ǵ����Ĳ���  ��ż����Ҫĳ��������ʱ��û�б�Ҫ����д���� ֱ��д��������
	}
}

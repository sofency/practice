package testLambda;

import java.awt.Toolkit;
import java.util.Arrays;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;
public class testLambda {
	public static void main(String[] args) {
		String[] plants=new String[] {"Mercury","Venus","Earth","Mars","Jupiter","Saturn"};
		System.out.println(Arrays.toString(plants));//输出字符串
		
		//按字母的顺序排序
		Arrays.sort(plants);
		System.out.println(Arrays.toString(plants));
		//使用匿名函数根据长度进行排序
		
		Arrays.sort(plants,(first,second)->first.length()-second.length());
		System.out.println(Arrays.toString(plants));
		
		Timer t=new Timer(1000, event->{//event是listener循环操作的时间
			System.out.println("the time is "+new Date()); 
			Toolkit.getDefaultToolkit().beep();
		});
		t.start();
		JOptionPane.showMessageDialog(null, "Quit programs?");
		System.exit(0);
		
		//int y=(x,m)->x+m;//目标类型的表达必须是一个函数接口
		//System.out.println(y);
		
		
		//总结匿名函数的优点  当需要一个功能的时候没有必要在写一个功能函数  然后new对象 然后传进函数  
		//这里的函数是代码块的操作  当偶尔需要某个代码块的时候没有必要进行写函数 直接写匿名函数
	}
}

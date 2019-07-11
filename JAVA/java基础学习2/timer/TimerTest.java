package timer;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TimerTest {

	public static void main(String[] args) {
		
		ActionListener listener=new TimePrinter();
		Timer t=new Timer(2000, listener);//构造定时器 每间隔interval毫秒会通知listener
		t.start();//启动定时器 启动成功定时器会调用监听器的actionPerformed
		JOptionPane.showMessageDialog(null, "Quit program");//
		//showMessageDialog(Component parent,Object message)  显示一个包含一条新消息和OK的对话框 这个对话框将位于
		//其parent组件的中间 如果 parent 是null ,则对话框位于屏幕的中间
		System.exit(0);
	}
}
class TimePrinter implements ActionListener {//实现事件监听器的接口actionPerformed

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("At the tone the time is "+new Date());
		Toolkit.getDefaultToolkit().beep();
	}
	
}

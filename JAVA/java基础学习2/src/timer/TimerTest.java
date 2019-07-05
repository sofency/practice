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
		Timer t=new Timer(2000, listener);//���춨ʱ�� ÿ���interval�����֪ͨlistener
		t.start();//������ʱ�� �����ɹ���ʱ������ü�������actionPerformed
		JOptionPane.showMessageDialog(null, "Quit program");//
		//showMessageDialog(Component parent,Object message)  ��ʾһ������һ������Ϣ��OK�ĶԻ��� ����Ի���λ��
		//��parent������м� ��� parent ��null ,��Ի���λ����Ļ���м�
		System.exit(0);
	}
}
class TimePrinter implements ActionListener {//ʵ���¼��������Ľӿ�actionPerformed

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("At the tone the time is "+new Date());
		Toolkit.getDefaultToolkit().beep();
	}
	
}

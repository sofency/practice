package �߼�����;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

public class MyTimer {
	public static void main(String[] args) {
		
		Timer time=new Timer();
		//time.schedule(new Mydate(), 3000,2000);//ִ�ж��
		//ָ��ʱ��ִ��
		try {
			time.schedule(new Mydate(),new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2019-07-14 19:13:50") , 2000);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

//������
class Mydate extends TimerTask{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("hello  world");
	}
	
}

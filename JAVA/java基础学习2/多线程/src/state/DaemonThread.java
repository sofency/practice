package state;

/**
 * daemon�ػ��߳� 
 *  Ĭ�����е��̶߳�Ϊ�û��߳�     �������Ҫ�ȴ��û��߳�ִ����ϲŻ�ֹͣ
 * @author sofency
 *
 */
public class DaemonThread {
	public static void main(String[] args) {
		
		God god=new God();
		You you=new You();
		
		Thread thread=new Thread(god);
		thread.setDaemon(true);//���û��ػ��߳�   ֱ���û��߳�ִ�����
		thread.start();
		
		new Thread(you).start();
		
		
		
	}
}


class You implements Runnable{
	
	@Override
	public void run() {
		for(int i=0;i<365*100;i++) {
			System.out.println(" happy life");
		}
		System.out.println("00000000");
		
	}
}

class God implements Runnable{
	
	@Override
	public void run() {
		for(;true;) {
			System.out.println(" ����");
		}
	}
}

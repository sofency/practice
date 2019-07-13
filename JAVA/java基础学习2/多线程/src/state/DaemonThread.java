package state;

/**
 * daemon守护线程 
 *  默认所有的线程都为用户线程     虚拟机需要等待用户线程执行完毕才会停止
 * @author sofency
 *
 */
public class DaemonThread {
	public static void main(String[] args) {
		
		God god=new God();
		You you=new You();
		
		Thread thread=new Thread(god);
		thread.setDaemon(true);//设置会守护线程   直到用户线程执行完毕
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
			System.out.println(" 永生");
		}
	}
}

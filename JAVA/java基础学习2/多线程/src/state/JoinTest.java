package state;

public class JoinTest {
	public static void main(String[] args) {
		
		new Thread(new Father()).start();
	}
	
}

class Father implements Runnable{
	
	public void run() {
		System.out.println("爸爸想抽烟，发现没烟了");
		System.out.println("让儿子去买中华");
		
		Thread t=new Thread(new Son());
		t.start();
		try {
			t.join();//将儿子的线程插入到这个线程中
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("爸爸接过烟 ，把零钱给了儿子");
		
	}
}

class  Son implements Runnable{

	@Override
	public void run() {
		System.out.println("儿子接过钱，发现一个游戏厅");
		for(int i=1;i<=10;i++) {
			try {
				Thread.sleep(1000);
				System.out.println(i+"秒过去了");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		System.out.println("赶紧买烟去");
		System.out.println("手拿一包中华回家了");
		
	}
	
}
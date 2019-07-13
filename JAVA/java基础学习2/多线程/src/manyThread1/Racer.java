package manyThread1;

public class Racer implements Runnable{

	
	private String winner;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		for(int step=1;step<=100;step++) {
			
			if(Thread.currentThread().getName().equals("rabbit") && step%10==0) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	
			System.out.println(Thread.currentThread().getName()+"--->"+step);
			boolean flag=gameOver(step);
			if(flag) {
				break;
			}
		}
	}
	
	public boolean gameOver(int step) {
		if(winner!=null) {//存在胜利者
			return true;
		}else {
			if(step==100) {
				winner=Thread.currentThread().getName();
				System.out.println("winner is===>"+winner);
				return true;
			}
			else {
				return false;
			}
		}
	}

	public static void main(String[] args) {
		//创建对象
		Racer race=new Racer();
		//多个流
		new Thread(race, "rabbit").start();
		new Thread(race, "tortoise").start();
	}
}

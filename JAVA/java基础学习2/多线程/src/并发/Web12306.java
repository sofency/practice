package 并发;

public class Web12306 {
	public static void main(String[] args) {
		BookWeb12306 book=new BookWeb12306(3,"洛阳");
		
		new Passenger(book, 2, "sofency").start();;
		new Passenger(book, 1, "alice").start();;
	}
}


class Passenger  extends Thread{
	int seats;
	public Passenger(Runnable target,int seats,String name) {//target就是指向目标
		// TODO Auto-generated constructor stub
		super(target,name);
		this.seats=seats;
	}
}


//火车订票网
class BookWeb12306 implements Runnable{
	int available;//位置数
	String name;//名称
	
	public  BookWeb12306(int available,String name) {
		this.available=available;
		this.name=name;
	}
	
	@Override
	public void run() {
		Passenger passenger=(Passenger)Thread.currentThread();
		boolean flag=this.bookTickets(passenger.seats);
		if(flag) {
			System.out.println("出票成功"+Thread.currentThread().getName()+"-位置为"+passenger.seats);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("出票失败"+Thread.currentThread().getName()+"-位置不够");
			
		}
	}	
	//购票
	public synchronized boolean bookTickets(int seats){
		System.out.println("可用位置为"+available);
		if(seats>available) {
			return false;
		}
		
		available-=seats;
		return true;
		
	}
}

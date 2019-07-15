package ����;

public class Web12306 {
	public static void main(String[] args) {
		BookWeb12306 book=new BookWeb12306(3,"����");
		
		new Passenger(book, 2, "sofency").start();;
		new Passenger(book, 1, "alice").start();;
	}
}


class Passenger  extends Thread{
	int seats;
	public Passenger(Runnable target,int seats,String name) {//target����ָ��Ŀ��
		// TODO Auto-generated constructor stub
		super(target,name);
		this.seats=seats;
	}
}


//�𳵶�Ʊ��
class BookWeb12306 implements Runnable{
	int available;//λ����
	String name;//����
	
	public  BookWeb12306(int available,String name) {
		this.available=available;
		this.name=name;
	}
	
	@Override
	public void run() {
		Passenger passenger=(Passenger)Thread.currentThread();
		boolean flag=this.bookTickets(passenger.seats);
		if(flag) {
			System.out.println("��Ʊ�ɹ�"+Thread.currentThread().getName()+"-λ��Ϊ"+passenger.seats);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("��Ʊʧ��"+Thread.currentThread().getName()+"-λ�ò���");
			
		}
	}	
	//��Ʊ
	public synchronized boolean bookTickets(int seats){
		System.out.println("����λ��Ϊ"+available);
		if(seats>available) {
			return false;
		}
		
		available-=seats;
		return true;
		
	}
}

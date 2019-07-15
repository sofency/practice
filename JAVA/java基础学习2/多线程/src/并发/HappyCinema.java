package 并发;


/**
 * 影院抢票系统
 */
import java.util.ArrayList;
import java.util.List;

public class HappyCinema {
	public static void main(String[] args) {
		List<Integer>  list=new  ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(7);

		//顾客选的位置
		
		List<Integer>  seat1=new  ArrayList<Integer>();
		seat1.add(1);
		seat1.add(2);
		
		List<Integer>  seat2=new  ArrayList<Integer>();
		seat2.add(4);
		seat2.add(5);
		seat2.add(6);
		
		
		Cinema cine=new  Cinema(list, "曲江国际影城");
		new Thread(new  Customer(cine,seat1),"sofency").start();
		new Thread(new Customer(cine, seat2),"alice").start();
		
		
		
	}

}

class Customer  implements Runnable{
	
	
	Cinema cinema;
	List<Integer> seats;
	
	public Customer(Cinema cinema,List<Integer> seats) {
		// TODO Auto-generated constructor stub
		this.cinema=cinema;
		this.seats=seats;
	}
	
	@Override
	public void run() {
		synchronized (cinema) {//操作的是影院的票数所以要锁住影院
			boolean flag=cinema.bookTickets(seats);
			if(flag) {
				System.out.print("出票成功"+Thread.currentThread().getName()+"-位置为"+seats);
				System.out.println();
			}else {
				System.out.println("出票失败"+Thread.currentThread().getName()+"-位置不够");
				
			}
		}
	}	
}
class Cinema{
	List<Integer> available;//位置数
	String name;//名称
	
	public  Cinema(List<Integer> available,String name) {
		this.available=available;
		this.name=name;
	}
	
	//购票
	public boolean bookTickets(List<Integer> seats){

		System.out.println("可用位置为"+available);
		List<Integer> copy=new  ArrayList<Integer>();
		copy.addAll(available);//将容器里面剩下的票放进去
		copy.removeAll(seats);//取出购买的票
		//有可能失败  因为可能写的票已经被购买了
		if(available.size()-copy.size()!=seats.size()) {
			return false;
		}
		available=copy;
		return true;
	}
	
	
}
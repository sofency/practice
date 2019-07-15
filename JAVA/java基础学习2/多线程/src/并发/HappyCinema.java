package ����;


/**
 * ӰԺ��Ʊϵͳ
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

		//�˿�ѡ��λ��
		
		List<Integer>  seat1=new  ArrayList<Integer>();
		seat1.add(1);
		seat1.add(2);
		
		List<Integer>  seat2=new  ArrayList<Integer>();
		seat2.add(4);
		seat2.add(5);
		seat2.add(6);
		
		
		Cinema cine=new  Cinema(list, "��������Ӱ��");
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
		synchronized (cinema) {//��������ӰԺ��Ʊ������Ҫ��סӰԺ
			boolean flag=cinema.bookTickets(seats);
			if(flag) {
				System.out.print("��Ʊ�ɹ�"+Thread.currentThread().getName()+"-λ��Ϊ"+seats);
				System.out.println();
			}else {
				System.out.println("��Ʊʧ��"+Thread.currentThread().getName()+"-λ�ò���");
				
			}
		}
	}	
}
class Cinema{
	List<Integer> available;//λ����
	String name;//����
	
	public  Cinema(List<Integer> available,String name) {
		this.available=available;
		this.name=name;
	}
	
	//��Ʊ
	public boolean bookTickets(List<Integer> seats){

		System.out.println("����λ��Ϊ"+available);
		List<Integer> copy=new  ArrayList<Integer>();
		copy.addAll(available);//����������ʣ�µ�Ʊ�Ž�ȥ
		copy.removeAll(seats);//ȡ�������Ʊ
		//�п���ʧ��  ��Ϊ����д��Ʊ�Ѿ���������
		if(available.size()-copy.size()!=seats.size()) {
			return false;
		}
		available=copy;
		return true;
	}
	
	
}
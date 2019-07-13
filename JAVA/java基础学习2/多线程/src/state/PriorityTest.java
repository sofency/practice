package state;

/**
 * �̵߳����ȼ�
 * 1.NORM_PRIORITY 5 Ĭ��
 * 2.MIN_PRIORITY 1
 * 3.MAX_PRIORITY 10
 * ֻ�Ǹ��ʵ�����  ��������Ե��Ⱥ�˳��
 * @author sofency
 *
 */
public class PriorityTest {
	public static void main(String[] args) {
		MYPriority mp=new MYPriority();
		
		Thread t1=new Thread(mp,"sofency");
		Thread t2=new Thread(mp,"alice");
		Thread t3=new Thread(mp,"ahoj");
		Thread t4=new Thread(mp,"sophia");
		Thread t5=new Thread(mp,"hello");
		Thread t6=new Thread(mp,"world");
		
		//������֮ǰ�������ȼ�
		
		t1.setPriority(Thread.MAX_PRIORITY-1);
		t2.setPriority(Thread.MAX_PRIORITY-2);
		t3.setPriority(Thread.MAX_PRIORITY-3);
		t4.setPriority(Thread.MIN_PRIORITY);
		t5.setPriority(Thread.MIN_PRIORITY);
		t6.setPriority(Thread.MIN_PRIORITY);
		
		
		//�������״̬
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		
		
		
	}

}

class MYPriority implements Runnable{
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+"--->"+Thread.currentThread().getPriority());
	}
}
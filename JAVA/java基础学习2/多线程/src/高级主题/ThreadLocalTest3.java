package �߼�����;

/**
 * �����̵߳Ĺ���  ������˭���߳�
 * run �������̱߳����
 * @author sofency
 *
 */

public class ThreadLocalTest3 {
	//private static ThreadLocal<Integer> threadLocal=new ThreadLocal<Integer>();
	
	//���ĳ�ʼֵ
	private static ThreadLocal<Integer> threadLocal=ThreadLocal.withInitial(()->1);//��ʼ��Ϊһ
	
	public static void main(String[] args) {
		//new Myrun();//����Ĵ�����ķ���  ֱ��������������
		
		new Thread(new Myrun(),"sofency").start();
		
	}
	
	public static class Myrun implements Runnable{

		public Myrun() {
			// TODO Auto-generated constructor stub
			System.out.println(Thread.currentThread().getName()+"ʣ����--->"+threadLocal.get());//�����main���߳�
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println(Thread.currentThread().getName()+"ʣ����--->"+threadLocal.get());//����Ƕ�����߳�

		}
		
	}

}

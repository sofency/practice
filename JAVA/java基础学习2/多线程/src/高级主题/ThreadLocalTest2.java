package �߼�����;

/**
 * ֻ��Ϊ��֤������߳�֮�����������ȫ������
 * @author sofency
 *
 */

public class ThreadLocalTest2 {
	//private static ThreadLocal<Integer> threadLocal=new ThreadLocal<Integer>();
	
	//���ĳ�ʼֵ
	private static ThreadLocal<Integer> threadLocal=ThreadLocal.withInitial(()->1);//��ʼ��Ϊһ
	
	public static void main(String[] args) {
		for(int i=0;i<5;i++) {
			new Thread(new Myrun(),"sofency"+i).start();
		}
	}
	
	public static class Myrun implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			Integer get=threadLocal.get();
			System.out.println(Thread.currentThread().getName()+"�õ���--->"+get);
			threadLocal.set(get-1);
			System.out.println(Thread.currentThread().getName()+"ʣ����--->"+threadLocal.get());

		}
		
	}

}

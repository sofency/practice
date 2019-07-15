package �߼�����;

public class ThreadLocalTest {
	//private static ThreadLocal<Integer> threadLocal=new ThreadLocal<Integer>();
	
	//���ĳ�ʼֵ
	private static ThreadLocal<Integer> threadLocal=new ThreadLocal<Integer>() {
		protected Integer initialValue() {
			return 200;
		};
	};
	
	public static void main(String[] args) {
		threadLocal.set(99);//ֻ���޸���main����Ĳ���
		System.out.println(Thread.currentThread().getName()+"--->"+threadLocal.get());
	
		
		new Thread(new Myrun(),"sofency").start();
	}
	
	public static class Myrun implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			threadLocal.set(120);//�޸�����
			System.out.println(Thread.currentThread().getName()+"--->"+threadLocal.get());
		}
		
	}

}

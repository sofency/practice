package �߼�����;

/**
 * inheritableThreadLocal  ;�̳������ĵ�����  ������һ�����ݸ����߳�
 * @author sofency
 *
 */

public class ThreadLocalTest4 {
	//private static ThreadLocal<Integer> threadLocal=new ThreadLocal<Integer>();
	
	//���ĳ�ʼֵ
	private static ThreadLocal<Integer> threadLocal=new InheritableThreadLocal<Integer>();//��ʼ��Ϊһ
	
	public static void main(String[] args) {
		//new Myrun();//����Ĵ�����ķ���  ֱ��������������
		System.out.println(Thread.currentThread().getName()+"--->"+threadLocal.get());
		
		threadLocal.set(2);
		System.out.println(Thread.currentThread().getName()+"--->"+threadLocal.get());
		
		new Thread(()->{
			System.out.println(Thread.currentThread().getName()+"--->"+threadLocal.get());
		}).start();//copy��main�߳���������� ���Ǽ̳еĹ�ϵ  ���Կ��������ݵĿ���
		
		
	}

}

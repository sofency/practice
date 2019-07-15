package �߼�����;


/**
 * DCL����ģʽ������ʽ��·  �ڶ��̻߳����� �������һ������
 * 1. ������˽�л�  ->  �����ⲿnew ������
 * 2. �ṩ��̬��˽������   ->�洢����ĵ�ַ
 * 3. �ṩ�����ľ�̬����  ->��ȡ����
 * @author sofency
 *
 */
public class DoubleCheckingTest {
	
	private static volatile DoubleCheckingTest instance;//����ʽ  û��volatile�����߳̿��ܷ���һ��û�г�ʼ���Ķ���
	//������˽�л�
	private DoubleCheckingTest() {
		
	}
	
//	�ṩ�����ľ�̬����  ->��ȡ����
	public static  DoubleCheckingTest getInstance() {
	
		//����һ���ⲿ����instanceΪ��ʱ ��ռ�ø���  ��������δ֪��ʵ��Ҳһֱ���Ŷӵȴ�   ����Ҫ����ǿ�ʵ���ĵȴ���Ҫ�ٽ�������ж�
		if(null!=instance) {
			return instance;
		}
		synchronized (DoubleCheckingTest.class) {			
			if(null==instance) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				instance=new DoubleCheckingTest();//���ܴ����ӳ�
				//���ܷ���ָ������
			}
		}
		return instance;
	}
	
	public static  DoubleCheckingTest getInstance1() {
		
		//����һ���ⲿ����instanceΪ��ʱ ��ռ�ø���  ��������δ֪��ʵ��Ҳһֱ���Ŷӵȴ�   ����Ҫ����ǿ�ʵ���ĵȴ���Ҫ�ٽ�������ж�
			
			if(null==instance) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				instance=new DoubleCheckingTest();//���ܴ����ӳ�
				//���ܷ���ָ������
			}
		    return instance;
	}
	
	
	
	
	public static void main(String[] args) {
//		new Thread(()->{
//			System.out.println(DoubleCheckingTest.getInstance1());
//		}).start();
//		
//		
//		new Thread(()->{
//			System.out.println(DoubleCheckingTest.getInstance1());//���������ܻ���ַ���ͳһ����õ���λ�ò�ͬ
//		}).start();
//		
		
		
		new Thread(()->{
			System.out.println(DoubleCheckingTest.getInstance());
		}).start();
		
		
		new Thread(()->{
			System.out.println(DoubleCheckingTest.getInstance());//������ᱣ֤���ӳ�֮���õ��ĵ�ַ����һ��
		}).start();
		
		
		
				
	}
}

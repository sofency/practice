package manyThread;
/**
 * �����̷߳�ʽһ   �̳�Thread ��дrun
 * @author sofency
 *
 */
public class ThreadTest extends Thread {
	
	public static void main(String[] args) {
		
		//�����߳�
		ThreadTest test=new ThreadTest();
		//�����߳�  run����ֻ�Ǽ򵥵ĵ��÷��� ���ᴴ���߳�
		test.start();  //�ڴ˴�����һ���߳�  ����ĳ������ִ��
		
		for(int i=0;i<20;i++) {
			System.out.println("hello world");
		}
		
	}
	
	@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=0;i<20;i++) {
				System.out.println("sofency");
			}
		}

}

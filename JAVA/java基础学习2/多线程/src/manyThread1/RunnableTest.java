package manyThread1;


/**
 * 1.ʵ��Runnable�ӿ�  ����Ŀ�����
 * 2. �����̶߳��� ����Ŀ�����
 * 3.�����߳�
 * @author sofency
 */
public class RunnableTest implements Runnable{

	public static void main(String[] args) {
//		1.����Ŀ�����
		RunnableTest  rTest=new RunnableTest();
//		2.�����߳�  ����Ŀ�����
		Thread t=new Thread(rTest);
//		3.ִ���߳�
		t.start();
		
//		����߳�ֻʹ��һ�εĻ�����ʹ������
//		new  Thread(new RunnableTest()).start();
		
		
		for (int i=0;i<20;i++) {
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

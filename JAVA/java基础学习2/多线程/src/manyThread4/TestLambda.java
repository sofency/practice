package manyThread4;

/**
 * lambda  ���̵߳�ʹ��
 * @author sofency
 *
 */
public class TestLambda {
	//��̬�ڲ���
	static class Test implements Runnable{//Runnable �ӿ�����ֻ��һ��run����
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (int i=0;i<20;i++) {
				System.out.println("listening");
			}
		}
	}
	public static void main(String[] args) {
//		new Thread(new Test()).start();//�����̵߳ľ�̬�ڲ���
		
		//�ֲ��ڲ���
		class Test1 implements Runnable{//Runnable �ӿ�����ֻ��һ��run����
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i=0;i<20;i++) {
					System.out.println("listening");
				}
			}
		}
		new  Thread(new Test1()).start();
		
		
		
		//�����ڲ���  
		new Thread(new Runnable() {//�������� ֻ�ø�����߽ӿ�ʵ�ַ���
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i=0;i<20;i++) {
					System.out.println("listening");
				}
			}
		}).start();
		
		
//		jdk8�ļ�
		//ʹ��lambda ���ʽ  ����ֻ��һ�ε���
		new Thread(()->{
			for (int i=0;i<20;i++) {
				System.out.println("listening");
			}
		}).start();
		
		
		
		
	}
	
	
	
	
	
	
	
	

}

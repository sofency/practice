package manyThread1;

/**
 * ������Դ�ᷢ���������� �����õ������ݿ��ܲ�׼ȷ
 * @author sofency
 *
 */
public class ShareThreadWithRunnable implements Runnable{

	private int ticketsNum=99;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			if(ticketsNum<0) {
				break;
			}else {
				System.out.println(Thread.currentThread().getName()+"----"+ticketsNum--);
			}
		}
	}
	public static void main(String[] args) {
		//��������
		ShareThreadWithRunnable  share=new ShareThreadWithRunnable();
		//�����߳� �������Դ
		new Thread(share, "test1").start();
		new Thread(share, "test2").start();
		new Thread(share, "test3").start();
	}
}

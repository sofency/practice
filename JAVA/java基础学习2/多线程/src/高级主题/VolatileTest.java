package �߼�����;

/**
 * volatile ���ڱ�֤���ݵ�ͬ��  Ҳ���ǿɼ���
 * @author sofency
 *
 */
public class VolatileTest {

	private volatile static int num=0;//����volatile�Ļ������һ���߳�ʼ�ռ�ⲻ��num�ı仯  ������ԭ����
	public static void main(String[] args) {
		
		new Thread(()->{
			while(num==0) {
				
			}
		}).start();
		
		try {
			Thread.sleep(1000);
			num=1;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

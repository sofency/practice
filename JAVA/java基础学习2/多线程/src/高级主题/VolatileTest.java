package 高级主题;

/**
 * volatile 用于保证数据的同步  也就是可见性
 * @author sofency
 *
 */
public class VolatileTest {

	private volatile static int num=0;//不加volatile的话下面第一个线程始终检测不到num的变化  不具有原子性
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

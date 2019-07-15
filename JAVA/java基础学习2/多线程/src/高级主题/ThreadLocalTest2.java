package 高级主题;

/**
 * 只是为了证明五个线程之间的数据是完全独立的
 * @author sofency
 *
 */

public class ThreadLocalTest2 {
	//private static ThreadLocal<Integer> threadLocal=new ThreadLocal<Integer>();
	
	//更改初始值
	private static ThreadLocal<Integer> threadLocal=ThreadLocal.withInitial(()->1);//初始化为一
	
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
			System.out.println(Thread.currentThread().getName()+"拿到了--->"+get);
			threadLocal.set(get-1);
			System.out.println(Thread.currentThread().getName()+"剩余了--->"+threadLocal.get());

		}
		
	}

}

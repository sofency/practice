package 高级主题;

public class ThreadLocalTest {
	//private static ThreadLocal<Integer> threadLocal=new ThreadLocal<Integer>();
	
	//更改初始值
	private static ThreadLocal<Integer> threadLocal=new ThreadLocal<Integer>() {
		protected Integer initialValue() {
			return 200;
		};
	};
	
	public static void main(String[] args) {
		threadLocal.set(99);//只是修改了main里面的参数
		System.out.println(Thread.currentThread().getName()+"--->"+threadLocal.get());
	
		
		new Thread(new Myrun(),"sofency").start();
	}
	
	public static class Myrun implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			threadLocal.set(120);//修改数据
			System.out.println(Thread.currentThread().getName()+"--->"+threadLocal.get());
		}
		
	}

}

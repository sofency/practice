package 高级主题;

/**
 * 分析线程的归属  即属于谁的线程
 * run 方法是线程本身的
 * @author sofency
 *
 */

public class ThreadLocalTest3 {
	//private static ThreadLocal<Integer> threadLocal=new ThreadLocal<Integer>();
	
	//更改初始值
	private static ThreadLocal<Integer> threadLocal=ThreadLocal.withInitial(()->1);//初始化为一
	
	public static void main(String[] args) {
		//new Myrun();//特殊的创造类的方法  直接在类加载中输出
		
		new Thread(new Myrun(),"sofency").start();
		
	}
	
	public static class Myrun implements Runnable{

		public Myrun() {
			// TODO Auto-generated constructor stub
			System.out.println(Thread.currentThread().getName()+"剩余了--->"+threadLocal.get());//这个是main的线程
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println(Thread.currentThread().getName()+"剩余了--->"+threadLocal.get());//这个是对象的线程

		}
		
	}

}

package 高级主题;

/**
 * inheritableThreadLocal  ;继承上下文的数据  即拷贝一份数据给子线程
 * @author sofency
 *
 */

public class ThreadLocalTest4 {
	//private static ThreadLocal<Integer> threadLocal=new ThreadLocal<Integer>();
	
	//更改初始值
	private static ThreadLocal<Integer> threadLocal=new InheritableThreadLocal<Integer>();//初始化为一
	
	public static void main(String[] args) {
		//new Myrun();//特殊的创造类的方法  直接在类加载中输出
		System.out.println(Thread.currentThread().getName()+"--->"+threadLocal.get());
		
		threadLocal.set(2);
		System.out.println(Thread.currentThread().getName()+"--->"+threadLocal.get());
		
		new Thread(()->{
			System.out.println(Thread.currentThread().getName()+"--->"+threadLocal.get());
		}).start();//copy了main线程里面的数据 不是继承的关系  可以看做是数据的拷贝
		
		
	}

}

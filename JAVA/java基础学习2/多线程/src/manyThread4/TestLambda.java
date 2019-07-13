package manyThread4;

/**
 * lambda  简化线程的使用
 * @author sofency
 *
 */
public class TestLambda {
	//静态内部类
	static class Test implements Runnable{//Runnable 接口里面只有一个run方法
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (int i=0;i<20;i++) {
				System.out.println("listening");
			}
		}
	}
	public static void main(String[] args) {
//		new Thread(new Test()).start();//启动线程的静态内部类
		
		//局部内部类
		class Test1 implements Runnable{//Runnable 接口里面只有一个run方法
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i=0;i<20;i++) {
					System.out.println("listening");
				}
			}
		}
		new  Thread(new Test1()).start();
		
		
		
		//匿名内部类  
		new Thread(new Runnable() {//不用子类 只用父类或者接口实现方法
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i=0;i<20;i++) {
					System.out.println("listening");
				}
			}
		}).start();
		
		
//		jdk8的简化
		//使用lambda 表达式  对于只用一次的类
		new Thread(()->{
			for (int i=0;i<20;i++) {
				System.out.println("listening");
			}
		}).start();
		
		
		
		
	}
	
	
	
	
	
	
	
	

}

package 高级主题;


/**
 * DCL单例模式：懒汉式套路  在多线程环境下 对外存在一个对象
 * 1. 构造器私有化  ->  避免外部new 构造器
 * 2. 提供静态的私有属性   ->存储对象的地址
 * 3. 提供公共的静态方法  ->获取属性
 * @author sofency
 *
 */
public class DoubleCheckingTest {
	
	private static volatile DoubleCheckingTest instance;//懒汉式  没有volatile其它线程可能访问一个没有初始化的对象
	//构造器私有化
	private DoubleCheckingTest() {
		
	}
	
//	提供公共的静态方法  ->获取属性
	public static  DoubleCheckingTest getInstance() {
	
		//当有一个外部满足instance为空时 则占用该锁  导致其它未知的实例也一直在排队等待   所以要避免非空实例的等待需要再进行添加判断
		if(null!=instance) {
			return instance;
		}
		synchronized (DoubleCheckingTest.class) {			
			if(null==instance) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				instance=new DoubleCheckingTest();//可能存在延迟
				//可能发生指令重排
			}
		}
		return instance;
	}
	
	public static  DoubleCheckingTest getInstance1() {
		
		//当有一个外部满足instance为空时 则占用该锁  导致其它未知的实例也一直在排队等待   所以要避免非空实例的等待需要再进行添加判断
			
			if(null==instance) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				instance=new DoubleCheckingTest();//可能存在延迟
				//可能发生指令重排
			}
		    return instance;
	}
	
	
	
	
	public static void main(String[] args) {
//		new Thread(()->{
//			System.out.println(DoubleCheckingTest.getInstance1());
//		}).start();
//		
//		
//		new Thread(()->{
//			System.out.println(DoubleCheckingTest.getInstance1());//不上锁可能会出现访问统一对象得到的位置不同
//		}).start();
//		
		
		
		new Thread(()->{
			System.out.println(DoubleCheckingTest.getInstance());
		}).start();
		
		
		new Thread(()->{
			System.out.println(DoubleCheckingTest.getInstance());//上锁后会保证在延迟之后拿到的地址依旧一样
		}).start();
		
		
		
				
	}
}

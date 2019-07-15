package 并发;


/**
 * 死锁 过多的同步可能会造成相互不释放资源
 * 从而相互等待  一般发生在  两个同步的锁内部又同时想调用对方的锁
 * @author sofency
 *
 */
public class DeadLock {
	public static void main(String[] args) {
		
		MakeUp g1=new MakeUp(1,"汪苏泷");
		MakeUp g2=new MakeUp(2,"蔡徐坤");
		g1.start();
		g2.start();
		
	}
}


//口红
class  LipStick{
	
}

//jingzi
class Mirror{
	
}

//化妆

class MakeUp extends Thread{
	static  LipStick lipStick=new LipStick();
	static  Mirror mirror=new Mirror();
	//选择
	int choice;
	
	//名字
	String  girl;
    public MakeUp(int choice,String girl) {
    	this.choice=choice;
    	this.girl=girl;
    }
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		 makeup();
	}
	//相互持有对方的对象锁
	private void  makeup() {
		
		if(choice==1) {
			synchronized (lipStick) {
				System.out.println(this.girl+"涂口红");
			
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//1秒以后想使用
				synchronized (mirror) {
					System.out.println(this.girl+"照镜子");
				}
			}
		}else {
			synchronized (mirror) {
				System.out.println(this.girl+"照镜子");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//3秒以后想使用
				synchronized (lipStick) {
					System.out.println(this.girl+"涂口红");
				}
		   }
	   }
		
	}
	
	
}


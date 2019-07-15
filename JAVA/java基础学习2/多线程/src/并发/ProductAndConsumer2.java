package 并发;
 
/**
 * 借助缓冲区  生产者 消费者  实现方式一 信号灯法   借助标志位进行生产者和消费者之间的转换
 * @author sofency
 *
 */
public class ProductAndConsumer2 {
	public static void main(String[] args) {
		Tv tv=new Tv();
		new Players(tv).start();
		new Watchers(tv).start();
		
	}
}


//生产者  演员
class Players extends Thread{
	Tv tv;
	
	
	public Players(Tv tv) {
		super();
		this.tv = tv;
	}


	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
            if (i%2==0){
                this.tv.play("天龙八部");
            }else {
                this.tv.play("广告：天才第一步，雀氏纸尿裤");
            }
        }
	}
}

//消费者

class Watchers extends Thread{
	Tv tv;
	public Watchers(Tv tv) {
		super();
		this.tv = tv;
	}

	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			tv.watch();
		}
		
		
		
	}
}

//操作的资源
class Tv{
	String voice;
	boolean flag=true;//如果为真 则
	
	//表演
	public synchronized void play(String voice) {
		//演员等待
		if(!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		System.out.println("演员来表演了"+voice);
		this.voice=voice;
		this.notifyAll();
		this.flag=!this.flag;//改变信号灯
		
	}
	
	//观看
		public synchronized void watch() {
			//观众等待
			if(flag) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
			System.out.println("观众听到了"+this.voice);
			this.notifyAll();
			this.flag=!this.flag;//改变信号灯
			
		}
	
	
}






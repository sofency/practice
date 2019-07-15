package 并发;

//协作模型： 生产者 消费者  实现方式一 管程法
/**
 * 借助缓冲区
 * @author sofency
 *
 */
public class ProductAndConsumer {
	public static void main(String[] args) {
		SynContainer container=new SynContainer();//缓冲区
		new Producer(container).start();//生产者
		new Consumer(container).start();//消费者	
	}
}


//生产者
class Producer extends Thread{
	
	SynContainer container;
	public Producer(SynContainer container) {
		super();
		this.container = container;
	}
	//生产者进行生产
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++) {
			System.out.println("生产第"+i+"个馒头");
			container.push(new Bread(i));
		}
	}	
}

//消费者
class Consumer extends Thread{
	SynContainer container;
	
	public Consumer(SynContainer container) {
		super();
		this.container = container;
	}
	//消费者进行购买
	@Override
	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println("消费第"+container.pop().id+"个馒头");
		}
	}
	
}
//缓冲区
class SynContainer{
	//缓冲区存放 多个产品
	Bread[] bre=new  Bread[10];//容量
	int count=0;
	//存储
	public synchronized void push(Bread bread) {
		//何时能生产  容器存在空间
		//不能生产
		
		if(count==bre.length) {
			try {
				this.wait();//消费者通知生产解除
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//存在空间 可以生产
		bre[count]=bread;
		count++;//向仓库中放入面包
		this.notifyAll();//通知消费
	}
	//拿取
	public  synchronized Bread pop() {
		//何时消费  容器中是否存在数据
		//没有数据只能等待
		
		if(count==0) {
			try {
				this.wait();//线程阻塞   生产者通知消费解除
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		count--;
		Bread bread=bre[count];
		this.notifyAll();//通知生产
		return bread;
	}
	
}
//产品

class Bread{
	int id;

	public Bread(int id) {
		super();
		this.id = id;
	}
}

package state;

/**
 * isAlive()  currentThread() 当前线程
 * @author sofency
 *
 */
public class InfoTest {

	public static void main(String[] args) throws InterruptedException {
		
		MyInfo my=new MyInfo("劳斯莱斯");
		Thread t=new Thread(my);//加入线程
		t.setName("程序员");
		t.start();
		
		
		Thread.sleep(1000);
		
		System.out.println(t.isAlive());//线程结束
	}
}


class MyInfo  implements Runnable{
	private String nameString;
    public MyInfo(String nameString) {
		super();
		this.nameString = nameString;
	}

    @Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+"--->"+nameString);
	}
	
}
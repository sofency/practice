package state;

/**
 * isAlive()  currentThread() ��ǰ�߳�
 * @author sofency
 *
 */
public class InfoTest {

	public static void main(String[] args) throws InterruptedException {
		
		MyInfo my=new MyInfo("��˹��˹");
		Thread t=new Thread(my);//�����߳�
		t.setName("����Ա");
		t.start();
		
		
		Thread.sleep(1000);
		
		System.out.println(t.isAlive());//�߳̽���
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
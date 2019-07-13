package state;

public class JoinTest {
	public static void main(String[] args) {
		
		new Thread(new Father()).start();
	}
	
}

class Father implements Runnable{
	
	public void run() {
		System.out.println("�ְ�����̣�����û����");
		System.out.println("�ö���ȥ���л�");
		
		Thread t=new Thread(new Son());
		t.start();
		try {
			t.join();//�����ӵ��̲߳��뵽����߳���
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("�ְֽӹ��� ������Ǯ���˶���");
		
	}
}

class  Son implements Runnable{

	@Override
	public void run() {
		System.out.println("���ӽӹ�Ǯ������һ����Ϸ��");
		for(int i=1;i<=10;i++) {
			try {
				Thread.sleep(1000);
				System.out.println(i+"���ȥ��");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		System.out.println("�Ͻ�����ȥ");
		System.out.println("����һ���л��ؼ���");
		
	}
	
}
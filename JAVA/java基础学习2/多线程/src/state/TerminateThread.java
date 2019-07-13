package state;

/**
 * 1.�߳�����ִ�����
 * 2.�ⲿ����--->�����ʶ
 * @author sofency
 *
 */
public class TerminateThread implements Runnable{
	private  boolean flag=true;//�����ʶ  ����߳����Ƿ����
	private String name;
	
	public TerminateThread(String name) {
		super();
		this.name = name;
	}

	public static void main(String[] args) {
		TerminateThread tt=new TerminateThread("c��");
		new Thread(tt).start();//ʹ�̴߳��ھ���״̬  ����״̬  -->����״̬
		
		for(int i=0;i<99;i++) {
			if(i==88) {
				tt.terminate();
				System.out.println("tt game over");
			}
			System.out.println("main--->"+i);
		}
		
		
		
		
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i=0;
		while(this.flag) {
			System.out.println("name is running--->"+i++);
		}
	}
	
	public void terminate() {
		this.flag=false;
	}

}

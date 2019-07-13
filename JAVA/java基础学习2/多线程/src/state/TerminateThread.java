package state;

/**
 * 1.线程正常执行完毕
 * 2.外部干涉--->假如标识
 * @author sofency
 *
 */
public class TerminateThread implements Runnable{
	private  boolean flag=true;//假如标识  标记线程体是否可用
	private String name;
	
	public TerminateThread(String name) {
		super();
		this.name = name;
	}

	public static void main(String[] args) {
		TerminateThread tt=new TerminateThread("c罗");
		new Thread(tt).start();//使线程处于就绪状态  新生状态  -->就绪状态
		
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

package state;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * sleep模拟倒计时
 * @author sofency
 *
 */
public class SleepThread {

	public static void main(String[] args) throws InterruptedException {
		
		//new Thread(new count()).start();
		
		Date endDate=new Date(System.currentTimeMillis()+1000*10);//十秒
		
		long endTime=endDate.getTime();//得到时间  
		while(true){
			
			System.out.println(new SimpleDateFormat("mm:ss").format(endDate));
			Thread.sleep(1000);
			endDate=new Date(endDate.getTime()-1000);
			if(endDate.getTime()+10000<endTime) {
				break;
			}
			
		}
	}	
}


class count implements Runnable{

	int i=10;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (i>0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i--);
		}
	}
}
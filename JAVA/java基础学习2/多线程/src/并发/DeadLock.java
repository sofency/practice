package ����;


/**
 * ���� �����ͬ�����ܻ�����໥���ͷ���Դ
 * �Ӷ��໥�ȴ�  һ�㷢����  ����ͬ�������ڲ���ͬʱ����öԷ�����
 * @author sofency
 *
 */
public class DeadLock {
	public static void main(String[] args) {
		
		MakeUp g1=new MakeUp(1,"������");
		MakeUp g2=new MakeUp(2,"������");
		g1.start();
		g2.start();
		
	}
}


//�ں�
class  LipStick{
	
}

//jingzi
class Mirror{
	
}

//��ױ

class MakeUp extends Thread{
	static  LipStick lipStick=new LipStick();
	static  Mirror mirror=new Mirror();
	//ѡ��
	int choice;
	
	//����
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
	//�໥���жԷ��Ķ�����
	private void  makeup() {
		
		if(choice==1) {
			synchronized (lipStick) {
				System.out.println(this.girl+"Ϳ�ں�");
			
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//1���Ժ���ʹ��
				synchronized (mirror) {
					System.out.println(this.girl+"�վ���");
				}
			}
		}else {
			synchronized (mirror) {
				System.out.println(this.girl+"�վ���");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//3���Ժ���ʹ��
				synchronized (lipStick) {
					System.out.println(this.girl+"Ϳ�ں�");
				}
		   }
	   }
		
	}
	
	
}


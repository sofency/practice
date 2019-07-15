package ����;
 
/**
 * ����������  ������ ������  ʵ�ַ�ʽһ �źŵƷ�   ������־λ���������ߺ�������֮���ת��
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


//������  ��Ա
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
                this.tv.play("�����˲�");
            }else {
                this.tv.play("��棺��ŵ�һ����ȸ��ֽ���");
            }
        }
	}
}

//������

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

//��������Դ
class Tv{
	String voice;
	boolean flag=true;//���Ϊ�� ��
	
	//����
	public synchronized void play(String voice) {
		//��Ա�ȴ�
		if(!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		System.out.println("��Ա��������"+voice);
		this.voice=voice;
		this.notifyAll();
		this.flag=!this.flag;//�ı��źŵ�
		
	}
	
	//�ۿ�
		public synchronized void watch() {
			//���ڵȴ�
			if(flag) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
			System.out.println("����������"+this.voice);
			this.notifyAll();
			this.flag=!this.flag;//�ı��źŵ�
			
		}
	
	
}






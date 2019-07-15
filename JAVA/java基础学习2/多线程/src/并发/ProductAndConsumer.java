package ����;

//Э��ģ�ͣ� ������ ������  ʵ�ַ�ʽһ �̷ܳ�
/**
 * ����������
 * @author sofency
 *
 */
public class ProductAndConsumer {
	public static void main(String[] args) {
		SynContainer container=new SynContainer();//������
		new Producer(container).start();//������
		new Consumer(container).start();//������	
	}
}


//������
class Producer extends Thread{
	
	SynContainer container;
	public Producer(SynContainer container) {
		super();
		this.container = container;
	}
	//�����߽�������
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++) {
			System.out.println("������"+i+"����ͷ");
			container.push(new Bread(i));
		}
	}	
}

//������
class Consumer extends Thread{
	SynContainer container;
	
	public Consumer(SynContainer container) {
		super();
		this.container = container;
	}
	//�����߽��й���
	@Override
	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println("���ѵ�"+container.pop().id+"����ͷ");
		}
	}
	
}
//������
class SynContainer{
	//��������� �����Ʒ
	Bread[] bre=new  Bread[10];//����
	int count=0;
	//�洢
	public synchronized void push(Bread bread) {
		//��ʱ������  �������ڿռ�
		//��������
		
		if(count==bre.length) {
			try {
				this.wait();//������֪ͨ�������
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//���ڿռ� ��������
		bre[count]=bread;
		count++;//��ֿ��з������
		this.notifyAll();//֪ͨ����
	}
	//��ȡ
	public  synchronized Bread pop() {
		//��ʱ����  �������Ƿ��������
		//û������ֻ�ܵȴ�
		
		if(count==0) {
			try {
				this.wait();//�߳�����   ������֪ͨ���ѽ��
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		count--;
		Bread bread=bre[count];
		this.notifyAll();//֪ͨ����
		return bread;
	}
	
}
//��Ʒ

class Bread{
	int id;

	public Bread(int id) {
		super();
		this.id = id;
	}
}

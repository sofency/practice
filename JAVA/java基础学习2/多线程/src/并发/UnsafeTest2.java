package ����;

/**
 * �̲߳���ȫ�����  �����и���  ���ݳ�����ͬ
 * @author sofency
 *
 */
public class UnsafeTest2 {
	public static void main(String[] args) {
		//�˻�
		
		Account account=new Account("������", 100);
		
		Drawing you=new Drawing(account, 80, "sofency");
		Drawing wife=new Drawing(account, 90, "alice");
		
		
		you.start();
		wife.start();
		
	}
}

class Account{
	String name;//�˻�
	int money;//Ǯ��

	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money = money;
	}


	public Account(String name, int money) {
		super();
		this.name = name;
		this.money = money;
	}
}


class Drawing extends Thread{
    Account account;
    int drawingMoney;                        //ȡ��Ǯ��
    int packetMoney;                         //�ڴ������Ǯ
   
	public Drawing(Account account, int drawingMoney,String name) {
		super(name);                         //���߳�������
		this.account = account;
		this.drawingMoney = drawingMoney;
	}

	@Override
	public void run() {
		if(account.money<drawingMoney||account.money<0) {
			System.out.println("�ʽ���");
			return ;
		}else {
			//ģ���ӳ�
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			account.money-=drawingMoney;
			packetMoney+=drawingMoney;
			
			System.out.println(this.getName()+"-->�˻����Ϊ:"+account.money);//��ȡ�����̵߳�����
			System.out.println(this.getName()+"-->�ڴ���ǮΪ:"+packetMoney);//��ȡ�����̵߳�����
			
		}
		
		
		
		
	}
}



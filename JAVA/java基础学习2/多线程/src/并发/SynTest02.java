package ����;

/**
 * �̲߳���ȫ�����  �����и���  ���ݳ�����ͬ
 * @author sofency
 *
 */
public class SynTest02 {
	public static void main(String[] args) {
		//�˻�
		AccountTest account=new AccountTest(1000, "����Ǯ");
		//ȡǮ����
		safeDrawingMoney you=new safeDrawingMoney(account,80,"sofency");	
		safeDrawingMoney wife=new safeDrawingMoney(account,90,"alice");	
		
		you.start();
		wife.start();
		
		
	}
}
//�˻�
class AccountTest{
	int money;
	String name;
	public AccountTest(int money, String name) {
		super();
		this.money = money;
		this.name = name;
	}
}


//ȡǮ����
class safeDrawingMoney extends Thread{
	AccountTest  account;
	private int getMoney;//ȡǮ
	private int packetMoney;//�ڴ������Ǯ
	
	public safeDrawingMoney(AccountTest account,int getMoney,String name) {
		super(name);
		this.account=account;
		this.getMoney = getMoney;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		test();
	}
	//���˻���ס�Է��������������
	public synchronized void test() {
		synchronized (account) {
			if(account.money-getMoney<0) {
				return;
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			account.money=account.money-getMoney;
			packetMoney+=getMoney;
			
			System.out.println(this.getName()+"�˻����Ϊ---->"+account.money);
			System.out.println(this.getName()+"�ڴ���ǮΪ---->"+packetMoney);
			
			
		}
		
		
		
		
	}
	
	
	
}





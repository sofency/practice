package 并发;

/**
 * 线程不安全的理解  数据有负数  数据出现相同
 * @author sofency
 *
 */
public class SynTest02 {
	public static void main(String[] args) {
		//账户
		AccountTest account=new AccountTest(1000, "结婚的钱");
		//取钱的人
		safeDrawingMoney you=new safeDrawingMoney(account,80,"sofency");	
		safeDrawingMoney wife=new safeDrawingMoney(account,90,"alice");	
		
		you.start();
		wife.start();
		
		
	}
}
//账户
class AccountTest{
	int money;
	String name;
	public AccountTest(int money, String name) {
		super();
		this.money = money;
		this.name = name;
	}
}


//取钱的人
class safeDrawingMoney extends Thread{
	AccountTest  account;
	private int getMoney;//取钱
	private int packetMoney;//口袋里面的钱
	
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
	//将账户锁住以防发生错误的数据
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
			
			System.out.println(this.getName()+"账户余额为---->"+account.money);
			System.out.println(this.getName()+"口袋的钱为---->"+packetMoney);
			
			
		}
		
		
		
		
	}
	
	
	
}





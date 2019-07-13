package 并发;

/**
 * 线程不安全的理解  数据有负数  数据出现相同
 * @author sofency
 *
 */
public class UnsafeTest2 {
	public static void main(String[] args) {
		//账户
		
		Account account=new Account("结婚礼金", 100);
		
		Drawing you=new Drawing(account, 80, "sofency");
		Drawing wife=new Drawing(account, 90, "alice");
		
		
		you.start();
		wife.start();
		
	}
}

class Account{
	String name;//账户
	int money;//钱数

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
    int drawingMoney;                        //取的钱数
    int packetMoney;                         //口袋里面的钱
   
	public Drawing(Account account, int drawingMoney,String name) {
		super(name);                         //给线程起名字
		this.account = account;
		this.drawingMoney = drawingMoney;
	}

	@Override
	public void run() {
		if(account.money<drawingMoney||account.money<0) {
			System.out.println("资金不足");
			return ;
		}else {
			//模拟延迟
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			account.money-=drawingMoney;
			packetMoney+=drawingMoney;
			
			System.out.println(this.getName()+"-->账户余额为:"+account.money);//获取的是线程的名字
			System.out.println(this.getName()+"-->口袋的钱为:"+packetMoney);//获取的是线程的名字
			
		}
		
		
		
		
	}
}



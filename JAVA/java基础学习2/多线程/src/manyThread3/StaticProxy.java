package manyThread3;

/**
 * 静态代理
 * 
 * 真实角色和代理角色之间要用借口进行通讯
 * 1.真实角色
 * 2.代理角色
 * @author sofency
 *
 */
public class StaticProxy {

	public static void main(String[] args) {
		new WeddingCompany(new You()).happyMarry();  
		//由婚庆公司代理你去准备现场  真正结婚的是你 随意你的动作实现
	}
}

interface Marry{
	void  happyMarry();
}

//真实角色
class You implements Marry{

	@Override
	public void happyMarry() {
		// TODO Auto-generated method stub
		System.out.println("你和他终于在一起了");
	}
	
}

//代理角色

class  WeddingCompany implements Marry{
//	要把对象放进来
	private Marry target;
	public WeddingCompany(Marry target) {
		this.target=target;
	}
	public void happyMarry() {
		// TODO Auto-generated method stub
		ready();
		this.target.happyMarry();
		after();
	}
	
	
	private void ready() {
		// TODO Auto-generated method stub
		System.out.println("布置现场");
	}
	
	private void after() {
		// TODO Auto-generated method stub
		System.out.println("闹洞房。。。");
		
	}
}
package decorateTest;

/**
 * 装饰器
 * @author sofency
 *
 */
public class Decorate1 {
	public static void main(String[] args) {
		
		Drink coffee=new Coffee(); 
	
		Drink suger=new suger(coffee);
		System.out.println(suger.info()+"--->"+suger.cost());
		
		Drink milk=new Milk(coffee);
		System.out.println(milk.info()+"--->"+milk.cost());
		
		milk=new Milk(suger);
		System.out.println(milk.info()+"--->"+milk.cost());
		
	}
}

//抽象组件
interface Drink{
	double cost();//价格
	String info();//信息
	
}
//具体组件
class Coffee implements Drink{  //不改变具体组件的功能直接在里面添加东西

	private String name="原味咖啡";

	@Override
	public double cost() {
		return 10;
	}

	@Override
	public String info() {
		return name;
	}
	
}

//抽象装饰类
abstract class decorat implements Drink{
	
	private Drink drink;//对抽象组件的引用
	
	public decorat(Drink drink) {
		this.drink=drink;
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return this.drink.cost();
	}

	@Override
	public String info() {
		// TODO Auto-generated method stub
		return this.drink.info();
	}
}

//具体装饰类

class Milk extends decorat{

	public Milk(Drink drink) {
		super(drink);
		// TODO Auto-generated constructor stub
	}
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return super.cost()*4;
	}

	@Override
	public String info() {
		// TODO Auto-generated method stub
		return super.info()+"加入了牛奶";//接口是在原来的功能基础上进行添加一些描述使其变的更加完整
	}
	//
	//
	//添加其他的代码
}

//具体装饰类

class suger extends decorat{

	public suger(Drink drink) {
		super(drink);
		// TODO Auto-generated constructor stub
	}
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return super.cost()*2;
	}

	@Override
	public String info() {
		// TODO Auto-generated method stub
		return super.info()+"加入了蔗糖";
	}
}



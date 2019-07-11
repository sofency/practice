package decorateTest;

/**
 * װ����
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

//�������
interface Drink{
	double cost();//�۸�
	String info();//��Ϣ
	
}
//�������
class Coffee implements Drink{  //���ı��������Ĺ���ֱ����������Ӷ���

	private String name="ԭζ����";

	@Override
	public double cost() {
		return 10;
	}

	@Override
	public String info() {
		return name;
	}
	
}

//����װ����
abstract class decorat implements Drink{
	
	private Drink drink;//�Գ������������
	
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

//����װ����

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
		return super.info()+"������ţ��";//�ӿ�����ԭ���Ĺ��ܻ����Ͻ������һЩ����ʹ���ĸ�������
	}
	//
	//
	//��������Ĵ���
}

//����װ����

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
		return super.info()+"����������";
	}
}



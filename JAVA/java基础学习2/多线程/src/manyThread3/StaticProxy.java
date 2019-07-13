package manyThread3;

/**
 * ��̬����
 * 
 * ��ʵ��ɫ�ʹ����ɫ֮��Ҫ�ý�ڽ���ͨѶ
 * 1.��ʵ��ɫ
 * 2.�����ɫ
 * @author sofency
 *
 */
public class StaticProxy {

	public static void main(String[] args) {
		new WeddingCompany(new You()).happyMarry();  
		//�ɻ��칫˾������ȥ׼���ֳ�  ������������ ������Ķ���ʵ��
	}
}

interface Marry{
	void  happyMarry();
}

//��ʵ��ɫ
class You implements Marry{

	@Override
	public void happyMarry() {
		// TODO Auto-generated method stub
		System.out.println("�����������һ����");
	}
	
}

//�����ɫ

class  WeddingCompany implements Marry{
//	Ҫ�Ѷ���Ž���
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
		System.out.println("�����ֳ�");
	}
	
	private void after() {
		// TODO Auto-generated method stub
		System.out.println("�ֶ���������");
		
	}
}
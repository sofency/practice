package testLambda;

//�Լ������lamdba�ӿ� �Լ�����
public class testAddeded {
	
	public static int adnum(int a,int b,test te) {//�����Լ��Ľӿ�
		return te.added(a,b);
	}
	public static void main(String[] args) {
		int a=12;
		int b=10;
		int get=adnum(a, b,(c,d)->{return c+d;});
		System.out.println(get);
	}
	
	
	

}

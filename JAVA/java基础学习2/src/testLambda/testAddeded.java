package testLambda;

//自己定义的lamdba接口 以及引用
public class testAddeded {
	
	public static int adnum(int a,int b,test te) {//引用自己的接口
		return te.added(a,b);
	}
	public static void main(String[] args) {
		int a=12;
		int b=10;
		int get=adnum(a, b,(c,d)->{return c+d;});
		System.out.println(get);
	}
	
	
	

}

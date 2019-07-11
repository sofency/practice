package 方法引用;

public class TestReferenceMehod {
	public static void main(String[] args) {
		double max=getMax(Math::pow, 2, 2);
		System.out.println(max);
		
		//int get=divi(testInterfece::divide, 10, 5); 目标类型必须是一个功能接口
	}
	
	public static double getMax(Comput com,int x,int y) {//Comput com 是借口
		return com.pow(x, y);
	}
	
	
}


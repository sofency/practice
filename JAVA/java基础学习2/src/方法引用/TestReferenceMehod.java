package ��������;

public class TestReferenceMehod {
	public static void main(String[] args) {
		double max=getMax(Math::pow, 2, 2);
		System.out.println(max);
		
		//int get=divi(testInterfece::divide, 10, 5); Ŀ�����ͱ�����һ�����ܽӿ�
	}
	
	public static double getMax(Comput com,int x,int y) {
		return com.pow(x, y);
	}
	
	
}


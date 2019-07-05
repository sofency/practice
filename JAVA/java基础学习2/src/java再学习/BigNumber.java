package java再学习;

import java.math.BigInteger;
import java.util.Scanner;

public class BigNumber {
	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		//使用大数进行运算n的阶乘
		Scanner in=new Scanner(System.in);
		System.out.println("请输入测试阶乘数");
		int number=in.nextInt();//输入要计算的阶乘的数字
		BigInteger size=computeSize(number);
		System.out.println(size);
		System.out.println();
		int cnt=count3(size);
		System.out.println(cnt);
		
	}
	public static BigInteger computeSize(int number) {
		BigInteger bigInteger=BigInteger.valueOf(1);//计算1000的阶乘
		for(int i=1;i<number;i++) {
			bigInteger=bigInteger.multiply(BigInteger.valueOf(i));//乘
		}
		return bigInteger;
	}
	
	//查看大数中有多少个3
	public static int count3(BigInteger bigInteger) {
		int cnt=0;
		while(bigInteger!=BigInteger.ZERO) {
			BigInteger temp=bigInteger.mod(BigInteger.valueOf(10));//取余
//			if(temp.equals(BigInteger.valueOf(3))) {//大数的比较用equals    不能用==进行比较
//				cnt++;
//			}
			//compareTo返回的是整数
			if(temp.compareTo(BigInteger.valueOf(3))==0) {//大数的比较用equals    不能用==进行比较
				cnt++;
			}
			bigInteger=bigInteger.divide(BigInteger.valueOf(10));//除  注意需要将10（int）转化为大整数
		}
		return cnt;
	}

	
}

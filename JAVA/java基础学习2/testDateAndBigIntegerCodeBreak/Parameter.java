package java再学习;

import java.util.Scanner;

/**
 * 
 * @author sofency  可变参数...的使用
 * 可变参数的小练习
 */
public class Parameter {
	public static void main(String[] args) {
		Scanner inScanner=new Scanner(System.in);
		System.out.println("请输入首加数字");
		int number=inScanner.nextInt();
		int sum=add(number,12,32,12,3,1);
		System.out.println(sum);
		
		int sum1=add(number,12,32);
		System.out.println(sum1);
	}
	public static int add(int x,int... args) {
		int sum=x;
		for(int i=0;i<args.length;i++) {
			sum+=args[i];
		}
		return sum;
	}
}

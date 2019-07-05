import java.util.Scanner;
public class GreatestCommonDivisorMethod{
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.print("Enter first integer:");
		int n1=input.nextInt();
		System.out.print("Enter second integer:");
		int n2=input.nextInt();
		long startTime=System.currentTimeMillis();
		int n=gcd1(n1,n2);
		System.out.println("the gcd of number "+n1+" and number "+n2+"is"+n);
		long endTime=System.currentTimeMillis();
		long testTime=endTime-startTime;
		System.out.println("it costs "+testTime+" ms");
	}

    public static int gcd1(int num1,int num2){
		int gcd=1;
		int k=2;
		while(k<=num1&&k<=num2){
			if(num1 % k == 0 && num2 % k == 0)
			{
				gcd=k;
			}
                      k++;
		}
		return gcd;
	}
}
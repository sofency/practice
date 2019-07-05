import java.util.Scanner;

public class GreatestCommonDivisor{
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		
		System.out.print("please enter first number£º");
		int  n1=input.nextInt();
		System.out.print("please enter second number: ");
		int n2=input.nextInt();
                long startTime=System.currentTimeMillis();
		if (n1<n2)
		{
			int temp=n1;
			n1=n2;
			n2=temp;
		}
		int mode=n1%n2;
		while(mode!=0)
		{
			n1=n2;
			n2=mode;
			mode=n1%n2;
		}
		System.out.println("the gcd is "+n2);
                long endTime=System.currentTimeMillis();
                long testTime=endTime-startTime;
                System.out.println("it costs "+testTime+" ms");
	}
}
package manyThread4;
/**
 * �Ƶ�lambda���ʽ
 * �������+ ����ֵ
 * @author sofency
 *
 */

public class TestLambda2 {

	public static void main(String[] args) {	
		iLove love=(int a) ->{
			System.out.println("i love lambda-->"+a);
		};
			
		love.love(2);
		//��ֻ��һ��������ʱ����Բ���д��������  ��ֻдһ��
		love=a->System.out.println("i love lambda-->"+a);
		love.love(3);
		
		//��������lambda
		iReturn ireturn=(a,b)->a+b;
		System.out.println(ireturn.returnValue(1, 2));
		
		ireturn=(a,b)->{
		   System.out.println("i love you"+(a+b));	
		   return a+b;
		};
		
		System.out.println(ireturn.returnValue(1, 2));
		
	}
}

interface iLove{
	void love(int a);
}

interface iReturn{
	int returnValue(int a,int b);
}





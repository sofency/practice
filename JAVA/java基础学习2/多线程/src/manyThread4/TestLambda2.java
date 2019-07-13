package manyThread4;
/**
 * 推导lambda表达式
 * 加入参数+ 返回值
 * @author sofency
 *
 */

public class TestLambda2 {

	public static void main(String[] args) {	
		iLove love=(int a) ->{
			System.out.println("i love lambda-->"+a);
		};
			
		love.love(2);
		//当只有一个参数的时候可以不用写参数类型  且只写一行
		love=a->System.out.println("i love lambda-->"+a);
		love.love(3);
		
		//带参数的lambda
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





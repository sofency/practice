package manyThread4;
/**
 * 推导lambda表达式
 * @author sofency
 *
 */

public class TestLambda1 {

	static class Like1 implements iLike{
		@Override
		public void lambda() {
			// TODO Auto-generated method stub
			System.out.println("i like lambda");
		}
	}
	public static void main(String[] args) {
		//1.正常写
		iLike like=new Like();//使用多态
		like.lambda();//进行调用
		//使用内部类
		
		like=new iLike() {
			@Override
			public void lambda() {
				// TODO Auto-generated method stub
				System.out.println("i like lambda");//使用内部类
			}
		};
		
		//使用lambda表达式
		
		like=()->{//向iLike里面进行推导属于哪个方法
			System.out.println("i like lambda");//使用内部类
		};
		
	}
}

interface iLike {
	void lambda();
}

class Like implements iLike{
	@Override
	public void lambda() {
		// TODO Auto-generated method stub
		System.out.println("i like lambda");
	}
}




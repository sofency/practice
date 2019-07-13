package manyThread4;
/**
 * �Ƶ�lambda���ʽ
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
		//1.����д
		iLike like=new Like();//ʹ�ö�̬
		like.lambda();//���е���
		//ʹ���ڲ���
		
		like=new iLike() {
			@Override
			public void lambda() {
				// TODO Auto-generated method stub
				System.out.println("i like lambda");//ʹ���ڲ���
			}
		};
		
		//ʹ��lambda���ʽ
		
		like=()->{//��iLike��������Ƶ������ĸ�����
			System.out.println("i like lambda");//ʹ���ڲ���
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




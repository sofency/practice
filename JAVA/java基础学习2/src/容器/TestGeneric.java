package 容器;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {
	public static void main(String[] args) {
		MyCollection<String> mc=new MyCollection<>();
		//向容器里面放入数据
		mc.set("高琪", 0);
		//mc.set(8888, 1);//报错的原因就是在String标签里面不能乱放
		//从数据里面拿取数据
		
		//Integer a=(Integer)mc.get(1);//拿取的话必须转化为对应的对象
		
		String name=(String)mc.get(0);
		
	}

}
class MyCollection<E>{
	Object[] objects=new Object[5];
	
	public void set(E e,int index) {
		objects[index]=e;
	}
	public E get(int index) {
		return (E)objects[index];
	}
}

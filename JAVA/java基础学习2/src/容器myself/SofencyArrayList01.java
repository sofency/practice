package 容器myself;

/**
 * 手写ArrayList 体会底层原理
 * @author sofency
 *
 */
public class SofencyArrayList01 {
	private Object[] elementData;
	private int size;
	
	private static final int DEFAULT_CAPACITY=10;
	
	public SofencyArrayList01(){
		elementData=new Object[DEFAULT_CAPACITY];//默认的容量是10
	}
	public SofencyArrayList01(int capacity) {
		 elementData=new Object[capacity];//传进数组列表的容量
	}

	public void add(Object obj) {//添加对象
		elementData[size++]=obj;//将对象加到默认的数组列表中
	}
	
	//重写toString方法
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder();
		sb.append("[");
		for (int i = 0; i < size; i++) {
			sb.append(elementData[i]+",");
		}
		sb.setCharAt(sb.length()-1, ']');
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		SofencyArrayList01 sofency=new SofencyArrayList01(20);//默认为20个对象
		sofency.add("aa");
		sofency.add("bb");
		System.out.println(sofency.toString());
	}
}

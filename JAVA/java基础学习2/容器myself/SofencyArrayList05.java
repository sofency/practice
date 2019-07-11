package 容器myself;

import java.io.ObjectInputStream.GetField;

import javax.management.RuntimeErrorException;

/**
 * 手写ArrayList 体会底层原理  实现remove
 * @author sofency
 *
 */
public class SofencyArrayList05<E> {
	private Object[] elementData;
	private int size;
	private static final int DEFAULT_CAPACITY=10;
	
	
	public SofencyArrayList05(){
		elementData=new Object[DEFAULT_CAPACITY];//默认的容量是10
	}
	
	
	public SofencyArrayList05(int capacity) {
		if(capacity<0) {
			throw new RuntimeException("容器的容量不能为零");
		}else if(capacity==0) {
			elementData=new Object[DEFAULT_CAPACITY];
		}else {
			 elementData=new Object[capacity];//传进数组列表的容量
		}
	}

	public void add(E e) {//添加对象
		
		if(size==elementData.length) {//什么时候扩容
			Object[] newArray=new Object[elementData.length+(elementData.length>>1)];//新创建数组 10->10+10/2 加号的优先级大于右移
			System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			
			elementData=newArray;//扩容
		}
		elementData[size++]=e;//将对象加到默认的数组列表中
	}
	
	
	
	public E get(int index) {
		
		checkRange(index);
		return (E)elementData[index];//强转为E类型
	}
	
	public void set(E element,int index) {//修改下标index的值
		checkRange(index);
		elementData[index]=element;
		
	}
	
	
	//移除元素
	public void  remove(E element) {
		for(int i=0;i<size;i++) {
			if(element.equals(get(i))) {
				remove(i);
			}	
		}
	}
	
	public void remove(int index) {
		
		int numMoved=elementData.length-index-1;
		if(numMoved>0) {
			System.arraycopy(elementData, index+1, elementData, index, numMoved);//复制后面的元素并且向前移动
		}
		elementData[--size]=null;
	}
	
	
	
	public int size() {
		return size;//返回数组的大小
	}
	
	public boolean isEmpty() {
		return size==0?true:false;
	}
	
	
	//检查下标的范围
	public void checkRange(int index) {
		if(index<0||index>size-1) {
			//不合法
			throw new RuntimeException("索引不合法");
		}
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
		SofencyArrayList05<String> sofency=new SofencyArrayList05<>(20);//默认为20个对象
		sofency.add("aa");
		sofency.add("bb");
		
		for(int i=0;i<40;i++) {
			sofency.add("sofency"+i);
		}
		
		System.out.println(sofency.toString());
		
		//System.out.println(sofency.get(10));
		
		sofency.remove(0);//根据下标删除
		System.out.println(sofency.toString());
		sofency.remove("bb");//根据元素删除
		System.out.println(sofency.toString());
		
		System.out.println(sofency.size());
		System.out.println(sofency.isEmpty());
		
		sofency.remove(1);
		System.out.println(sofency.size());
		
	}
}

package ����myself;

import java.io.ObjectInputStream.GetField;

import javax.management.RuntimeErrorException;

/**
 * ��дArrayList ���ײ�ԭ��  ʵ��get��set
 * @author sofency
 *
 */
public class SofencyArrayList04<E> {
	private Object[] elementData;
	private int size;
	private static final int DEFAULT_CAPACITY=10;
	
	
	public SofencyArrayList04(){
		elementData=new Object[DEFAULT_CAPACITY];//Ĭ�ϵ�������10
	}
	
	
	public SofencyArrayList04(int capacity) {
		if(capacity<0) {
			throw new RuntimeException("��������������Ϊ��");
		}else if(capacity==0) {
			elementData=new Object[DEFAULT_CAPACITY];
		}else {
			 elementData=new Object[capacity];//���������б������
		}
	}

	public void add(E e) {//��Ӷ���
		
		if(size==elementData.length) {//ʲôʱ������
			Object[] newArray=new Object[elementData.length+(elementData.length>>1)];//�´������� 10->10+10/2 �Ӻŵ����ȼ���������
			System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			
			elementData=newArray;//����
		}
		elementData[size++]=e;//������ӵ�Ĭ�ϵ������б���
	}
	
	//��дtoString����
	
	public E get(int index) {
		
		checkRange(index);
		return (E)elementData[index];//ǿתΪE����
	}
	
	public void set(E element,int index) {//�޸��±�index��ֵ
		checkRange(index);
		elementData[index]=element;
		
	}
	
	public void checkRange(int index) {
		if(index<0||index>size-1) {
			//���Ϸ�
			throw new RuntimeException("�������Ϸ�");
		}
	}
	
	
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
		SofencyArrayList04<String> sofency=new SofencyArrayList04<>(20);//Ĭ��Ϊ20������
		sofency.add("aa");
		sofency.add("bb");
		
		for(int i=0;i<40;i++) {
			sofency.add("sofency"+i);
		}
		
		System.out.println(sofency.toString());
		
		System.out.println(sofency.get(10));
	}
}

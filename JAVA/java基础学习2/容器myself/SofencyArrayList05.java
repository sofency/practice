package ����myself;

import java.io.ObjectInputStream.GetField;

import javax.management.RuntimeErrorException;

/**
 * ��дArrayList ���ײ�ԭ��  ʵ��remove
 * @author sofency
 *
 */
public class SofencyArrayList05<E> {
	private Object[] elementData;
	private int size;
	private static final int DEFAULT_CAPACITY=10;
	
	
	public SofencyArrayList05(){
		elementData=new Object[DEFAULT_CAPACITY];//Ĭ�ϵ�������10
	}
	
	
	public SofencyArrayList05(int capacity) {
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
	
	
	
	public E get(int index) {
		
		checkRange(index);
		return (E)elementData[index];//ǿתΪE����
	}
	
	public void set(E element,int index) {//�޸��±�index��ֵ
		checkRange(index);
		elementData[index]=element;
		
	}
	
	
	//�Ƴ�Ԫ��
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
			System.arraycopy(elementData, index+1, elementData, index, numMoved);//���ƺ����Ԫ�ز�����ǰ�ƶ�
		}
		elementData[--size]=null;
	}
	
	
	
	public int size() {
		return size;//��������Ĵ�С
	}
	
	public boolean isEmpty() {
		return size==0?true:false;
	}
	
	
	//����±�ķ�Χ
	public void checkRange(int index) {
		if(index<0||index>size-1) {
			//���Ϸ�
			throw new RuntimeException("�������Ϸ�");
		}
	}
	
	//��дtoString����
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
		SofencyArrayList05<String> sofency=new SofencyArrayList05<>(20);//Ĭ��Ϊ20������
		sofency.add("aa");
		sofency.add("bb");
		
		for(int i=0;i<40;i++) {
			sofency.add("sofency"+i);
		}
		
		System.out.println(sofency.toString());
		
		//System.out.println(sofency.get(10));
		
		sofency.remove(0);//�����±�ɾ��
		System.out.println(sofency.toString());
		sofency.remove("bb");//����Ԫ��ɾ��
		System.out.println(sofency.toString());
		
		System.out.println(sofency.size());
		System.out.println(sofency.isEmpty());
		
		sofency.remove(1);
		System.out.println(sofency.size());
		
	}
}

package ����myself;

/**
 * ��дArrayList ���ײ�ԭ��
 * @author sofency
 *
 */
public class SofencyArrayList02<E> {
	private Object[] elementData;
	private int size;
	
	private static final int DEFAULT_CAPACITY=10;
	
	public SofencyArrayList02(){
		elementData=new Object[DEFAULT_CAPACITY];//Ĭ�ϵ�������10
	}
	public SofencyArrayList02(int capacity) {
		 elementData=new Object[capacity];//���������б������
	}

	public void add(E e) {//��Ӷ���
		elementData[size++]=e;//������ӵ�Ĭ�ϵ������б���
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
		SofencyArrayList02<String> sofency=new SofencyArrayList02<>(20);//Ĭ��Ϊ20������
		sofency.add("aa");
		sofency.add("bb");
		System.out.println(sofency.toString());
	}
}

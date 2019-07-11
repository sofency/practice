package ����myself;

/**
 * ��дArrayList ���ײ�ԭ��
 * @author sofency
 *
 */
public class SofencyArrayList03<E> {
	private Object[] elementData;
	private int size;
	
	private static final int DEFAULT_CAPACITY=10;
	
	public SofencyArrayList03(){
		elementData=new Object[DEFAULT_CAPACITY];//Ĭ�ϵ�������10
	}
	public SofencyArrayList03(int capacity) {
		 elementData=new Object[capacity];//���������б������
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
		SofencyArrayList03<String> sofency=new SofencyArrayList03<>(20);//Ĭ��Ϊ20������
		sofency.add("aa");
		sofency.add("bb");
		
		for(int i=0;i<40;i++) {
			sofency.add("sofency"+i);
		}
		System.out.println(sofency.toString());
	}
}

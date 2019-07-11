package testMap;

/**
 * 
 * @author sofency
 *
 */
public class SofencyHashMap3 {
	
	Node[] table;//λͰ����
	int size;//��ż�ֵ�Եĸ���
	
	public SofencyHashMap3() {
		table =new Node[16];//����һ�㶨���2����������
	}
	
	
	public void put(Object key,Object value) {
		//�����½��Ķ���
		Node newNode=new Node();//Ҫ���õĽ��
		newNode.hash=myHash(key.hashCode(), table.length);//��ȡhashֵ
		newNode.key=key;
		newNode.value=value;
		newNode.next=null;
		
		//���ж�key��λ���Ƿ���ֵ
		Node temp=table[newNode.hash];
		Node iterLast=null;
		
		boolean keyRepeat=false;
		if(temp==null) {
			//�˴�����Ϊ�� ��ֱ�ӽ� �½ڵ�Ž�ȥ
			table[newNode.hash]=newNode;
			size++;
		}else {
			while(temp!=null) {
				//�ж�keyֵ�Ƿ��ͻ
				if(temp.key.equals(key)) {
					keyRepeat=true;
					temp.value=value;//ֻ�Ǹ���value��ֵ
					break;//�˳�ѭ��
					
				}else {
					
					iterLast=temp;//�������һ�����
					temp=temp.next;
				}
			}
			if(!keyRepeat) {
			    iterLast.next=newNode;
			    size++;
		    }
		}
	}
	
	//hash���㷨
	public int myHash(int v,int length) {
		return v&(length-1);//������length-1
	}

	//get����
	public Object get(Object key) {
		//����hashֵ Ȼ��ֱ������λ�� Ȼ���������
		int hash=myHash(key.hashCode(), table.length);
		Object value=null;
		if(table[hash]!=null) {
			
			Node temp=table[hash];
			while(temp!=null) {
				
				if(temp.key.equals(key)) {
					value=temp.value;
					break;
				}else {
					temp=temp.next;//���²���
				}
			}
		}
	
		return value;		
	}
	
	
	@Override
	public String toString() {
		//ʵ��Ч��{10:aa,20:bb}
		
		StringBuilder sb=new StringBuilder();
		sb.append('{');
		
		for(int i=0;i<table.length;i++) {
			Node temp=table[i];
			
			if(temp!=null) {
				while(temp!=null) {
					sb.append(temp.key+":"+temp.value+",");//��Ӽ�ֵ��
					temp=temp.next;//ָ���������һ��Ԫ��
				}
			}
		}
		
		sb.setCharAt(sb.length()-1, '}');
		return sb.toString();
	}
	
	public static void main(String[] args) {
		SofencyHashMap3 map=new SofencyHashMap3();
		map.put(10, "sofency");
		map.put(17, "alice");
		map.put(11, "ahoj");
		map.put(26, "hahia");
		map.put(42, "manager");
		
		
		System.out.println(map);
		
		
		System.out.println(map.get(42));
	}
	

}

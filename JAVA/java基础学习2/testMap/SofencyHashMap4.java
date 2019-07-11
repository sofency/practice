package testMap;

/**
 * 
 * @author sofency
 *
 */
public class SofencyHashMap4<K,V> {
	
	Node2<K,V>[] table;//λͰ����
	int size;//��ż�ֵ�Եĸ���
	
	
	@SuppressWarnings("unchecked")
	public SofencyHashMap4() {
		table =new Node2[16];//����һ�㶨���2����������
	}
	
	
	
	public void put(K key,V value) {
		//�����½��Ķ���
		Node2<K, V> newNode=new Node2<K, V>();//Ҫ���õĽ��
		newNode.hash=myHash(key.hashCode(), table.length);//��ȡhashֵ
		newNode.key=key;
		newNode.value=value;
		newNode.next=null;
		
		//���ж�key��λ���Ƿ���ֵ
		Node2<K, V> temp=table[newNode.hash];
		Node2<K, V> iterLast=null;
		
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
	@SuppressWarnings("unchecked")
	public V get(K key) {
		//����hashֵ Ȼ��ֱ������λ�� Ȼ���������
		int hash=myHash(key.hashCode(), table.length);
		Object value=null;
		if(table[hash]!=null) {
			
			Node2<K, V> temp=table[hash];
			while(temp!=null) {
				
				if(temp.key.equals(key)) {
					value=temp.value;
					break;
				}else {
					temp=temp.next;//���²���
				}
			}
		}
	
		return (V) value;		
	}
	
	
	@Override
	public String toString() {
		//ʵ��Ч��{10:aa,20:bb}
		
		StringBuilder sb=new StringBuilder();
		sb.append('{');
		
		for(int i=0;i<table.length;i++) {
			Node2<K, V> temp=table[i];
			
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
		SofencyHashMap4<Integer,String> map=new SofencyHashMap4<>();
		map.put(10, "sofency");
		map.put(17, "alice");
		map.put(11, "ahoj");
		map.put(26, "hahia");
		map.put(42, "manager");
		
		System.out.println(map);
		
		
		System.out.println(map.get(42));
	}
}

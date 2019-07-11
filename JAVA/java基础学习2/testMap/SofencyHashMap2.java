package testMap;

/**
 * ʵ��toString ����  ����map�Ĳ�ѯ
 * @author sofency
 *
 */
public class SofencyHashMap2 {
	
	Node[] table;//λͰ����
	int size;//��ż�ֵ�Եĸ���
	
	public SofencyHashMap2() {
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
		    }
		}
	}
	
	//hash���㷨
	public int myHash(int v,int length) {
		return v&(length-1);//������length-1
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
		SofencyHashMap2 map=new SofencyHashMap2();
		map.put(10, "sofency");
		map.put(17, "alice");
		map.put(11, "ahoj");
		map.put(26, "hahia");
		map.put(42, "manager");
		
		
		System.out.println(map);
	}
	

}

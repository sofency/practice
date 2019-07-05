package testMap;

/**
 * 
 * @author sofency
 *
 */
public class SofencyHashMap4<K,V> {
	
	Node2<K,V>[] table;//位桶数组
	int size;//存放键值对的个数
	
	
	@SuppressWarnings("unchecked")
	public SofencyHashMap4() {
		table =new Node2[16];//长度一般定义成2的整数次幂
	}
	
	
	
	public void put(K key,V value) {
		//定义新结点的对象
		Node2<K, V> newNode=new Node2<K, V>();//要放置的结点
		newNode.hash=myHash(key.hashCode(), table.length);//获取hash值
		newNode.key=key;
		newNode.value=value;
		newNode.next=null;
		
		//先判断key的位置是否有值
		Node2<K, V> temp=table[newNode.hash];
		Node2<K, V> iterLast=null;
		
		boolean keyRepeat=false;
		if(temp==null) {
			//此处数组为空 则直接将 新节点放进去
			table[newNode.hash]=newNode;
			size++;
		}else {
			while(temp!=null) {
				//判断key值是否冲突
				if(temp.key.equals(key)) {
					keyRepeat=true;
					temp.value=value;//只是覆盖value的值
					break;//退出循环
					
				}else {
					
					iterLast=temp;//保存最后一个结点
					temp=temp.next;
				}
			}
			if(!keyRepeat) {
			    iterLast.next=newNode;
			    size++;
		    }
		}
	}
	
	//hash的算法
	public int myHash(int v,int length) {
		return v&(length-1);//必须是length-1
	}

	//get方法
	@SuppressWarnings("unchecked")
	public V get(K key) {
		//先求hash值 然后直接锁定位数 然后链表查找
		int hash=myHash(key.hashCode(), table.length);
		Object value=null;
		if(table[hash]!=null) {
			
			Node2<K, V> temp=table[hash];
			while(temp!=null) {
				
				if(temp.key.equals(key)) {
					value=temp.value;
					break;
				}else {
					temp=temp.next;//向下查找
				}
			}
		}
	
		return (V) value;		
	}
	
	
	@Override
	public String toString() {
		//实现效果{10:aa,20:bb}
		
		StringBuilder sb=new StringBuilder();
		sb.append('{');
		
		for(int i=0;i<table.length;i++) {
			Node2<K, V> temp=table[i];
			
			if(temp!=null) {
				while(temp!=null) {
					sb.append(temp.key+":"+temp.value+",");//添加键值对
					temp=temp.next;//指向链表的下一个元素
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

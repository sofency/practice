package testMap;

/**
 * 实现toString 方法  方便map的查询
 * @author sofency
 *
 */
public class SofencyHashMap2 {
	
	Node[] table;//位桶数组
	int size;//存放键值对的个数
	
	public SofencyHashMap2() {
		table =new Node[16];//长度一般定义成2的整数次幂
	}
	
	
	public void put(Object key,Object value) {
		//定义新结点的对象
		Node newNode=new Node();//要放置的结点
		newNode.hash=myHash(key.hashCode(), table.length);//获取hash值
		newNode.key=key;
		newNode.value=value;
		newNode.next=null;
		
		//先判断key的位置是否有值
		Node temp=table[newNode.hash];
		Node iterLast=null;
		
		boolean keyRepeat=false;
		if(temp==null) {
			//此处数组为空 则直接将 新节点放进去
			table[newNode.hash]=newNode;
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
		    }
		}
	}
	
	//hash的算法
	public int myHash(int v,int length) {
		return v&(length-1);//必须是length-1
	}

	
	@Override
	public String toString() {
		//实现效果{10:aa,20:bb}
		
		StringBuilder sb=new StringBuilder();
		sb.append('{');
		
		for(int i=0;i<table.length;i++) {
			Node temp=table[i];
			
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
		SofencyHashMap2 map=new SofencyHashMap2();
		map.put(10, "sofency");
		map.put(17, "alice");
		map.put(11, "ahoj");
		map.put(26, "hahia");
		map.put(42, "manager");
		
		
		System.out.println(map);
	}
	

}

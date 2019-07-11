package testMap;

/**
 * 解决了键值对的添加  覆盖键重复的value值
 * @author sofency
 *
 */
public class SofencyHashMap {
	
	Node[] table;//位桶数组
	int size;//存放键值对的个数
	
	public SofencyHashMap() {
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
	
	
	public static void main(String[] args) {
		SofencyHashMap map=new SofencyHashMap();
		map.put(10, "sofency");
		map.put(17, "alice");
		map.put(11, "ahoj");
		map.put(26, "hahia");
		map.put(42, "manager");
		
		
		System.out.println(map);
	}
	

}

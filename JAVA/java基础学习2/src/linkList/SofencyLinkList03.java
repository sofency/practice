package linkList;


/**
 * 添加remove插入结点方法
 * @author sofency
 *
 */

public class SofencyLinkList03<E> {
	
	private Node first; //链表的最前一个元素
	private Node last; //链表的最后一个元素
	private int size;//链表的大小

	//add方法实现
	public void add(E obj) {
		
		Node node=new Node(obj);//包含元素的结点
		
		if(first==null) {
			first=node;//第一个元素是结点
			last=node;//最后一个元素是结点
		}else {
			node.previousNode=last;//指向最后一个结点
			node.next=null;//下一个结点为空
			
			last.next=node;//因为此时的last还是指向第二个元素
			last=node; //更新last
		}
		size++;//链表的大小
	}
	
	//在特定位置插入一个结点
	
	public  void add(int index,E element) {
		checkRange(index);//检查结点的正确性
		
		Node temp=getNode(index);//获取到当前的结点
		Node node=new Node(element);//new结点
		
		
		if(temp!=null) {
			
			if(index==0) {
				node.next=temp;
				temp.previousNode=node;
				first=node;
			}else if(index==size-1) {
				node.next=null;
				node.previousNode=temp;
				temp.next=node;
				last=node;
			}else {
				Node upNode =temp.previousNode;//获取到上一节点
				
				upNode.next=node;
				node.previousNode=upNode;
				
				node.next=temp;
				temp.previousNode=node;		
			}
			
		}
		size++;
	}
	
	
	//[a,b,f,c,d,f]
	//get方法的实现
	@SuppressWarnings("unchecked")
	public E get(int index) {
		checkRange(index);
		Node node=getNode(index);
		return node!=null?(E)node.element:null;
	}
	
	
	private Node getNode(int index) {
		Node temp=null;
		int head=0;
		if(index<size/2) {
			temp=first;//等于头部
			while(head<index) {
				temp=temp.next;
				head++;
			}
		}else {
			temp=last;//等于尾部
			head=size-1;
			while(head>index) {
				temp=temp.previousNode;
				head--;
				
			}
		}
		return temp;
	}
	
	
	public void remove(int index) {
		
		checkRange(index);
		Node temp=getNode(index);//获取到要删除的结点
		
		if(temp!=null) {
			Node upNode=temp.previousNode;
			Node dowNode=temp.next;
			
			if(upNode!=null) {
				upNode.next=dowNode;			
			}
			
			if(dowNode!=null) {
				dowNode.previousNode=upNode;			
			}
			
			if(index==0) {
				first=dowNode;
			}
			if(index==size-1) {
				last=upNode;
			}
			size--;
			
		}
	}
	
	
	private void checkRange(int index) {
		if(index<0||index>size-1) {
			throw new RuntimeException("下标异常");
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		
		sb.append("[");//增加左中括号
		
		//按个遍历链表中的元素
		Node temp=first;
		while(temp!=null) {
			sb.append(temp.element+",");
			temp=temp.next;
		}
		sb.setCharAt(sb.length()-1, ']');
		return sb.toString();//返回结点的字符串序列
		
		
	}

	
	public static void main(String[] args) {
		
		SofencyLinkList03<String> link=new SofencyLinkList03<>();//创建链表
		link.add("a");
		link.add("b");
		link.add("c");
		link.add("a");
		link.add("b");
		link.add("c");
		System.out.println(link);
		System.out.println(link.get(4));//获取下标为0的元素
		
		//删除元素
		
		link.remove(0);
		System.out.println(link);
		link.remove(4);
		System.out.println(link);
		
		link.add(2,"sofency");
		System.out.println(link);
		
		link.add(0,"ahoj");
		System.out.println(link);
		
		link.add(5,"ahoj");
		System.out.println(link);
		System.out.println(link.size);
		
	}
	
	
	
}

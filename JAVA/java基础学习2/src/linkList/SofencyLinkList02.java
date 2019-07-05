package linkList;


/**
 * 添加remove删除结点方法
 * @author sofency
 *
 */

public class SofencyLinkList02 {
	
	private Node first; //链表的最前一个元素
	private Node last; //链表的最后一个元素
	private int size;//链表的大小

	//add方法实现
	public void add(Object obj) {
		
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
	
	
	//[a,b,f,c,d,f]
	//get方法的实现
	public Object get(int index) {
		if(index<0||index>size-1) {
			throw new RuntimeException("下标异常");
		}
		Node node=getNode(index);
		return node!=null?node.element:null;
	}
	
	
	public Node getNode(int index) {
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
		
		SofencyLinkList02 link=new SofencyLinkList02();//创建链表
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
		link.remove(5);
		System.out.println(link);
		
		
	}
	
	
	
}

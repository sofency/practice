package linkList;


/**
 * ���removeɾ����㷽��
 * @author sofency
 *
 */

public class SofencyLinkList02 {
	
	private Node first; //�������ǰһ��Ԫ��
	private Node last; //��������һ��Ԫ��
	private int size;//����Ĵ�С

	//add����ʵ��
	public void add(Object obj) {
		
		Node node=new Node(obj);//����Ԫ�صĽ��
		
		if(first==null) {
			first=node;//��һ��Ԫ���ǽ��
			last=node;//���һ��Ԫ���ǽ��
		}else {
			node.previousNode=last;//ָ�����һ�����
			node.next=null;//��һ�����Ϊ��
			
			last.next=node;//��Ϊ��ʱ��last����ָ��ڶ���Ԫ��
			last=node; //����last
		}
		size++;//����Ĵ�С
	}
	
	
	//[a,b,f,c,d,f]
	//get������ʵ��
	public Object get(int index) {
		if(index<0||index>size-1) {
			throw new RuntimeException("�±��쳣");
		}
		Node node=getNode(index);
		return node!=null?node.element:null;
	}
	
	
	public Node getNode(int index) {
		Node temp=null;
		int head=0;
		if(index<size/2) {
			temp=first;//����ͷ��
			while(head<index) {
				temp=temp.next;
				head++;
			}
		}else {
			temp=last;//����β��
			head=size-1;
			while(head>index) {
				temp=temp.previousNode;
				head--;
				
			}
		}
		return temp;
	}
	
	
	public void remove(int index) {
		Node temp=getNode(index);//��ȡ��Ҫɾ���Ľ��
		
		
		
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
		
		sb.append("[");//������������
		
		//�������������е�Ԫ��
		Node temp=first;
		while(temp!=null) {
			sb.append(temp.element+",");
			temp=temp.next;
		}
		sb.setCharAt(sb.length()-1, ']');
		
		
		return sb.toString();//���ؽ����ַ�������
		
		
	}
	public static void main(String[] args) {
		
		SofencyLinkList02 link=new SofencyLinkList02();//��������
		link.add("a");
		link.add("b");
		link.add("c");
		link.add("a");
		link.add("b");
		link.add("c");
		System.out.println(link);
		System.out.println(link.get(4));//��ȡ�±�Ϊ0��Ԫ��
		
		//ɾ��Ԫ��
		
		link.remove(0);
		System.out.println(link);
		link.remove(5);
		System.out.println(link);
		
		
	}
	
	
	
}

package linkList;

public class Node {
	Node previousNode;//��һ�����
	Node next;//��һ�����
	Object element;//Ԫ������
  
  	public Node(Node previousNode, Node next, Object element) {
		super();
		this.previousNode = previousNode;
		this.next = next;
		this.element = element;
  	}

	public Node(Object element) {
		super();
		this.element = element;
	}
  
  
}

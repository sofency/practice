package linkList;

public class Node {
	Node previousNode;//上一个结点
	Node next;//下一个结点
	Object element;//元素数据
  
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

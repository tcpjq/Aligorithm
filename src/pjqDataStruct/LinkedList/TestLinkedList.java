package pjqDataStruct.LinkedList;

public class TestLinkedList {
	
	public static void main(String[] args) {
		Node node = new Node(0);
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(2);
		
		LinkedList linkedList = new LinkedList();
		linkedList.insert(node);	linkedList.insert(node1);
		linkedList.insert(node2);	linkedList.insert(node3);
		
		linkedList.show(linkedList.root);
		
		//反转
//		Node res = linkedList.reverse(linkedList.root);
//		System.out.println();  linkedList.show(res);
		
		Node res = linkedList.reverse1(linkedList.root);
		System.out.println();  linkedList.show(res);
	}

}

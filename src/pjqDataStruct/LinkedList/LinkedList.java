package pjqDataStruct.LinkedList;

public class LinkedList {
	public Node root;
	
	//构造链表
	public void insert(Node newNode) {
		if(this.root == null) {
			this.root = newNode;
		}else {
			Node tmp = this.root;
			while(tmp.next != null) {
				tmp = tmp.next;
			}
			tmp.next = newNode;
		}
	}
	
	//遍历链表
	public void show(Node root) {
		if(root == null) {
			System.out.println("root is null");
			return;
		}else {
			Node tmp = root;
			while(tmp != null) {
				System.out.print(tmp.val + " ");
				tmp = tmp.next;
			}
		}
	}
	
	/**
	 * 构造头结点 resultNode；针对原有链表循环遍历节点，将该节点添加到头结点后面
	 * 该节点的next = 头结点的next   头节点.next = 该节点
	 * 缺陷：创建了一个新的链表
	 * @param root
	 * @return
	 */
	public Node reverse(Node root) {
		Node resultNode = new Node(-1);
		//循环节点
		Node head = root;
		while(head != null) {
			Node temp = head.next;
			head.next = resultNode.next;
			resultNode.next = head;
			head = temp;
		}
		return resultNode.next;
	}
	/**
	 * 链表反转：原地反转  ；  并不需要创建新的链表
	 * 构造一个头节点，将第二个节点插入头结点和第一个节点中间，同时修改next指针。
	 * @param front
	 * @param now
	 */
	public Node reverse1(Node root) {
		Node res = new Node(-1);
		res.next = root;
		Node tmp = root;
		Node pNext = tmp.next;
		while(pNext != null) {
			tmp.next = pNext.next;  
			//tmp就是第一个root，通过tmp.next赋值，可在pNext.next为空的时候，(为原来链表的头结点，现在链表的尾节点 的) next为空，遍历的时候避免了死循环。
			pNext.next = res.next;
			res.next = pNext;
			pNext = tmp.next;
		}
		return res.next;
	}
	/**
	 * 链表反转：递归  从后到前递归
	 * https://blog.csdn.net/Wu_ye123/article/details/88729736
	 * 将链表节点一直递归压栈 到最后一个节点。
	 * @param root
	 * @return
	 */
	public Node reverse2(Node root) {
		if(root == null || root.next == null) {
			return root;
		}
		Node head = reverse2(root);
		root.next.next = root;  //让root的下个节点 的 下个节点指向自己。（反转）
		root.next = null;  //让root的下个节点置为空。
		
		return head;
	}

	
}

class Node {
	public int val;  //链表节点的值
	public Node next;  //next指针
	
	public Node(int val) {
		this.val = val;
	}
	
}
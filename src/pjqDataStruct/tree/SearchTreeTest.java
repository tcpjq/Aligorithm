package pjqDataStruct.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 搜索二叉树实现
 *
 */
public class SearchTreeTest {
	public static void main(String[] args) {
		SearchTree searchTree = new SearchTree();
		searchTree.inorder(1);  //当前数为空
		searchTree.inorder(2);  //当前数为空
		searchTree.preorder(1);
		
		
		//插入数据：3 1 8 4 6 0 2 9
		searchTree.insert(3);searchTree.insert(1);searchTree.insert(8);searchTree.insert(4);
		searchTree.insert(6);searchTree.insert(0);searchTree.insert(2);searchTree.insert(9);
		/**
		 *         3
		 *    1        8
		 *  0   2    4   9
		 *            6
		 */
		
		searchTree.inorder(1);  //递归中序遍历： 0 1 2 3 4 6 8 9 
		searchTree.inorder(2);  //非递归中序遍历： 0 1 2 3 4 6 8 9 
		searchTree.preorder(1); //递归前序遍历：3 1 0 2 8 4 6 9 
		searchTree.preorder(2); //非递归前序遍历：3 1 0 2 8 4 6 9 
		searchTree.postorder(1);  //递归后序遍历：0 2 1 5 4 9 8 3
		searchTree.postorder(2);
	}
}

/**
 * 二叉树，树的构建，树的遍历...
 */
class SearchTree {
	public SearchTreeNode root;
	
	//插入节点到二叉树
	public void insert(int data) {
		SearchTreeNode newNode = new SearchTreeNode();
		newNode.data = data;
		
		if(root == null) {
			root = newNode;
		}else {
			SearchTreeNode curNode = root;
			while(true) {
				if(newNode.data > curNode.data) {
					if(curNode.rightNode != null) {
						curNode = curNode.rightNode;
					}else {
						curNode.rightNode = newNode;
						return;
					}
				}else {
					if(curNode.leftNode != null) {
						curNode = curNode.leftNode;
					}else {
						curNode.leftNode = newNode;
						return;
					}
				}
			}
		}
	}

	//递归中序遍历：左中右。flag:1表示递归；   2表示非递归。
	public void inorder(int flag) {
		System.out.println("---------中序遍历---------");
		if(root == null) {
			System.out.println("当前树为空");
			return;
		}
		if(flag == 1) {
			inorderRecursion(root);
			System.out.println();
		}else {
			inorder(root);
			System.out.println();
		}
	}
	/**
	 * 递归的操作：无需关注内部逻辑，只需要关注整体调用即可。然后自己调用自己。
	 */
	private void inorderRecursion(SearchTreeNode root) {  //递归中序遍历
		if(root.leftNode != null) {  //输出左边
			inorderRecursion(root.leftNode);
		}
		System.out.print(root.data + " ");  //输出中间
		if(root.rightNode != null) {   //输出右边
			inorderRecursion(root.rightNode);
		}
	}
	//https://blog.csdn.net/u012535132/article/details/84329729
	private void inorder(SearchTreeNode root) {   //非递归中序遍历，使用栈，默认root不为空
		Stack<SearchTreeNode> stack = new Stack<SearchTreeNode>();
		SearchTreeNode tmp = root;
		stack.push(tmp);
		while(!stack.isEmpty()) {
			if(tmp != null && tmp.leftNode != null) {
				tmp = tmp.leftNode;
				stack.push(tmp);
			}else {
				tmp = stack.pop();
				System.out.print(tmp.data + " ");
				if(tmp != null && tmp.rightNode != null) {
					tmp = tmp.rightNode;
					stack.push(tmp);
				}else {
					tmp = null;  //标记为已经访问过了
				}
			}
		}
	}

	/**
	 * 前序遍历:根左右
	 */
	public void preorder(int flag) {
		System.out.println("---------前序遍历---------");
		if(root == null) {
			System.out.println("当前树为空");
			return;
		}
		if(flag == 1) {
			preorderRecurision(root);
			System.out.println();
		}else {
			preorder(root);
			System.out.println();
		}
		
	}
	private void preorderRecurision(SearchTreeNode root) { //递归前序遍历
		System.out.print(root.data + " ");
		if(root.leftNode != null) {
			preorderRecurision(root.leftNode);
		}
		if(root.rightNode != null) {
			preorderRecurision(root.rightNode);
		}
	}
	//https://www.cnblogs.com/bigsai/p/11393609.html
	private void preorder(SearchTreeNode root) {
		Stack<SearchTreeNode> stack = new Stack<SearchTreeNode>();
		SearchTreeNode tmp = root;
		stack.push(tmp);
		while(!stack.isEmpty()) {
			tmp = stack.pop();
			System.out.print(tmp.data + " ");

			if(tmp.rightNode != null) {
				stack.push(tmp.rightNode);
			}
			if(tmp.leftNode != null) {;
				stack.push(tmp.leftNode);
			}
			
		}
	}
	
	//后序遍历：左右根
	public void postorder(int flag) {
		System.out.println("---------后序遍历-------");
		if(root == null) {
			System.out.println("树为空");
			return;
		}
		if(flag == 1) {
			postorderRecurision(root);
			System.out.println();
		}else {
			postorder(root);
			System.out.println();
		}
	}
	private void postorderRecurision(SearchTreeNode root) {
		if(root.leftNode != null) {
			postorderRecurision(root.leftNode);
		}
		if(root.rightNode != null) {
			postorderRecurision(root.rightNode);
		}
		System.out.print(root.data + " ");
	}
	private void postorder(SearchTreeNode root) {
		Stack<SearchTreeNode> stack = new Stack<SearchTreeNode>();
		SearchTreeNode tmp = root;
		Map<Integer,Integer> map = new HashMap();

		while(!stack.isEmpty() || tmp != null) {
			if(tmp != null) {
				stack.push(tmp);
				map.put(tmp.data, 1);
				tmp = tmp.leftNode;
			}else {
				tmp = stack.peek();
				if(map.get(tmp.data) == 2) {
					stack.pop();
					System.out.print(tmp.data + " ");
					tmp = null;
				}else {
					map.put(tmp.data, 2);
					tmp = tmp.rightNode;
				}
			}
		}
	}
}

//树节点
class SearchTreeNode{
	public int data;
	public SearchTreeNode leftNode;
	public SearchTreeNode rightNode;
}

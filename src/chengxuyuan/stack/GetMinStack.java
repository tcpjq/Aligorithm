package chengxuyuan.stack;

import java.util.Stack;

/**
 * 第1章 栈和队列
 * 设计具有getMin功能的栈
 *
 */
public class GetMinStack {
	
	public static void main(String[] args) {
		MyStack1 mystack1 = new MyStack1();
		mystack1.push(3); mystack1.push(4); mystack1.push(5); mystack1.push(1);
		mystack1.push(2); mystack1.push(1); mystack1.push(7); mystack1.push(1);
		System.out.println(mystack1.getMin());
		mystack1.pop();  mystack1.pop();  mystack1.pop();  mystack1.pop(); 
		mystack1.pop();  mystack1.pop();
		System.out.println(mystack1.getMin());
		
		MyStack2 mystack2 = new MyStack2();
		mystack2.push(3); mystack2.push(4); mystack2.push(5); mystack2.push(1);
		mystack2.push(2); mystack2.push(1); mystack2.push(7); mystack2.push(1);
		System.out.println(mystack2.getMin());
		mystack2.pop();  mystack2.pop();  mystack2.pop();  mystack2.pop();
		mystack2.pop();  mystack2.pop();
		System.out.println(mystack2.getMin());
	}
	

}

class MyStack1 {
	public Stack<Integer> stackData;
	public Stack<Integer> stackMin;
	
	public MyStack1() {
		stackData = new Stack<Integer>();
		stackMin = new Stack<Integer>();
	}
	
	public void push(int newNum) {
		//直接添加进数值栈
		this.stackData.push(newNum);
		//判断当前值与最小值栈的大小
		if(this.stackMin.isEmpty()) {
			this.stackMin.push(newNum);
		}else if(newNum <= this.getMin()) {
			this.stackMin.push(newNum);
		}
	}
	
	public int pop() {
		if(this.stackData.isEmpty()) {
			throw new RuntimeException("栈为空");
		}
		
		int value =  this.stackData.pop();
		if(value == this.getMin()) {
			this.stackMin.pop();
		}
		
		return value;
	}
	
	public int getMin() {
		if(this.stackMin.isEmpty()) {
			throw new RuntimeException("栈为空");
		}else {
			return this.stackMin.peek();
		}
	}
}

class MyStack2 {
	public Stack<Integer> stackData;
	public Stack<Integer> stackMin;
	
	public MyStack2() {
		stackData = new Stack<Integer>();
		stackMin = new Stack<Integer>();
	}
	
	public void push(int newNum) {
		//直接添加进数值栈
		this.stackData.push(newNum);
		//判断当前值与最小值栈的大小
		if(this.stackMin.isEmpty()) {
			this.stackMin.push(newNum);
		}else if(newNum <= this.getMin()) {
			this.stackMin.push(newNum);
		}else {
			this.stackMin.push(this.getMin());
		}
	}
	
	public int pop() {
		if(this.stackData.isEmpty()) {
			throw new RuntimeException("栈为空");
		}
		
		int value =  this.stackData.pop();
		this.stackMin.pop();
		
		return value;
	}
	
	public int getMin() {
		if(this.stackMin.isEmpty()) {
			throw new RuntimeException("栈为空");
		}else {
			return this.stackMin.peek();
		}
	}
}
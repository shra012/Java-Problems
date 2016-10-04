/**
 * 
 */
package com.shrvn.stack;

import com.shrvn.ds.stack.ArrayStack;
import com.shrvn.ds.stack.Stack;

/**
 * @author shravan
 *
 */
public class ArrayStackMain {

	/**
	 * Driver method to test my array stack
	 * @param args
	 */
	public static void main(String[] args) {
		Stack<Integer> S = new ArrayStack<>();
		S.push(5);
		S.push(3);
		System.out.println(S.size());
		System.out.println(S.pop());
		System.out.println(S.isEmpty());
		System.out.println(S.pop());
		System.out.println(S.isEmpty());
		System.out.println(S.pop());
		S.push(7);
		S.push(9); System.out.println(S.top());
		S.push(4); System.out.println(S.size());
		System.out.println(S.pop());
		S.push(6);
		S.push(8);
		S.push(223);
		System.out.println(S.pop());
		ArrayStack<Integer> A=(ArrayStack<Integer>) S;
		A.printStack(A.getData());
	}

}

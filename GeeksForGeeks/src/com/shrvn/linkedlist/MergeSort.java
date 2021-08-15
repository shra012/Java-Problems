/**
 * 
 */
package com.shrvn.linkedlist;

import com.shrvn.ds.linkedlist.LinkedList;
import com.shrvn.ds.linkedlist.LinkedList.Node;

/**
 * @author 965922
 *
 */
public class MergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.append(1);
		list.append(0);
		list.append(3);
		list.append(2);
		list.append(6);
		list.append(5);
		list.append(8);
		list.append(7);
		printList(sort(list.getHead()));
	}

	public static Node sort(Node head){
		if(head.next==null || head==null){
			return head;
		}
		Node front=new Node();
		Node back=new Node();
		frontBackSplit(head,front,back);
		front=front.next;
		back = back.next;
		front=sort(front);
		back = sort(back);
		head= SortedMerge(front,back);
		return head;
	}

	static void frontBackSplit(Node head,Node front,Node back) {

		Node front_last_node=null;
		Node slow = head;
		Node fast = head;
		while ( fast!=null && fast.next!=null) {
			front_last_node = slow;
			slow = slow.next;
			fast = (fast.next!=null) ? fast.next.next : null;
		}
		if(fast!=null){
			front_last_node = slow;
			slow=front_last_node.next;
		}
		front_last_node.next = null;  // ends the front sublist
		front.next = head;
		back.next = slow;
	}

	public static Node SortedMerge(Node a,Node b) {
		Node result = null;

		/* Base cases */
		if (a == null) 
			return b;
		else if (b==null) 
			return a;

		/* Pick either a or b, and recur */
		if (a.data <= b.data) {
			result = a;
			result.next = SortedMerge(a.next, b);
		}else{
			result = b;
			result.next = SortedMerge(a, b.next);
		}
		return result;
	}

	public static void printList(Node head){
		Node temp = head;
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}

}

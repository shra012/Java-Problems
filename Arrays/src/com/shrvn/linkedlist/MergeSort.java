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
		sort(list.getHead());
	}

	public static void sort(Node head){
		Node front=head;
		Node back=head;
		frontBackSplit(head,front,back);
		sort(front);
		sort(back);
		head= SortedMerg(front,back);
		printList(head);
	}

	static void frontBackSplit(Node head, Node front, Node back) {
		if (head==null) return;  // Handle empty list
		Node front_last_node=null;
		Node slow = head;
		Node fast = head;
		while (fast!=null) {
			front_last_node = slow;
			slow = slow.next;
			fast = (fast.next!=null) ? fast.next.next : null;
		}
		front_last_node.next = null;  // ends the front sublist
		front = head;
		back = slow;
	}

	public static Node SortedMerg(Node a,Node b) {
		Node result = null;

		/* Base cases */
		if (a == null) 
			return b;
		else if (b==null) 
			return a;

		/* Pick either a or b, and recur */
		if (a.data <= b.data) {
			result = a;
			result.next = SortedMerg(a.next, b);
		}else{
			result = b;
			result.next = SortedMerg(a, b.next);
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

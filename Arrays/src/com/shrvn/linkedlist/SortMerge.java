/**
 * 
 */
package com.shrvn.linkedlist;

import com.shrvn.ds.linkedlist.LinkedList;
import com.shrvn.ds.linkedlist.LinkedList.Node;

/**
 * @author shravan
 *
 */
public class SortMerge {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList a = new LinkedList();
		a.push(4);
		a.push(3);
		a.printList();
		LinkedList b = new LinkedList();
		b.push(2);
		b.push(1);
		b.printList();
		LinkedList result = new LinkedList();
		Node c =result.getHead();
		c=SortedMerg(a.getHead(),b.getHead());
		printList(c);

	}
	
	public static Node SortedMerg( Node a,  Node b) {
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

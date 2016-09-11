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
public class Merge {

	/**
	 * Input : Head of following linked list  
		      a--> 1->2->NULL
		      b--> 3->4->NULL
		Output : Linked list should be changed to,
		      c--> 4->3->2->1->NULL

		Input : Head of following linked list  
		      a--> 1->3->5->NULL
		      b--> 2->4->NULL
		Output : Linked list should be changed to,
		      c--> 1->2->3->4->5->NULL
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

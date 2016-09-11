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
public class Reverse {

	/**
	 *  Input : Head of following linked list  
		       1->2->3->4->NULL
		Output : Linked list should be changed to,
		       4->3->2->1->NULL

		Input : Head of following linked list  
		       1->2->3->4->5->NULL
		Output : Linked list should be changed to,
		       5->4->3->2->1->NULL
	 */
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.push(4);
		list.push(3);
		list.push(2);
		list.push(1);
		list.printList();
		//list.reverseList();
		//list.printList();
		list.recursiveReverse(list.getHead());
		list.printList();
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
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
		//FrontBackSplit(list.getHead());	

	}
		
	static void FrontBackSplit(Node head, Node front, Node back) {
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
	

}

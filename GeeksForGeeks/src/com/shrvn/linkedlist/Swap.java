/**
 * 
 */
package com.shrvn.linkedlist;

import com.shrvn.ds.linkedlist.LinkedList;
/**
 * @author shravan
 *
 */
public class Swap {

	/**
	 * LinkedList Swap
	 *  Input:  10->15->12->13->20->14,  x = 12, y = 20
		Output: 10->15->20->13->12->14
		
		Input:  10->15->12->13->20->14,  x = 10, y = 20
		Output: 20->15->12->13->10->14
		
		Input:  10->15->12->13->20->14,  x = 12, y = 13
		Output: 10->15->13->12->20->14
	 */
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.append(10);
		list.append(15);
		list.append(12);
		list.append(13);
		list.append(11);
		list.append(14);
		list.append(20);
		list.printList();
		list.swap(12, 13); //Added Swap Method in My LinkedList
		list.printList();
	}

}

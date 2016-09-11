/**
 * 
 */
package com.shrvn.ds.linkedlist;

/**
 * @author 965922
 *
 */
public class LinkedList {

	Node head;
	public class Node{
		Node next;
		int data;
		public Node(int data) {
			this.data = data;
			this.next =null; 
		}
	}
	public void push(int new_data){
		Node new_node = new Node(new_data);
		new_node.next=head;
		head=new_node;
	}

	public void append(int new_data){
		Node new_node = new Node(new_data);
		if(head==null){
			head=new_node;
			return;
		}
		Node temp=head;
		while(temp.next!=null){
			temp=temp.next;
		}
		temp.next=new_node;
		return;
	}

	public void push(Node prev_node,int data){
		if(prev_node==null){
			System.out.println("The given previous node is null.");
			return;
		}

		Node new_node = new Node(data);
		new_node.next=prev_node.next;
		prev_node.next = new_node;
	}

	public void deleteKey(int data){
		Node temp = head,prev_node=null;
		if(temp != null && temp.data == data){
			head=temp.next;
			return;
		}
		while(temp!=null && temp.data!=data){
			prev_node=temp;
			temp=temp.next;
		}
		if(temp==null){
			return;
		}
		prev_node.next=temp.next;
		return;
	}

	public void deletePosition(int position){
		if(head==null){
			return;
		}
		Node temp = head,prev_node=null;
		if(position==0){
			head=temp.next;
			return;
		}
		int i=0;
		while(temp!=null && i!=position){
			prev_node=temp;
			temp=temp.next;
			i++;
		}
		prev_node.next=temp.next;
		return;
	}

	public void printList(){
		Node temp = head;
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
	public int length(Node node){
		return 1+length(node);
	}

	public void swap(int firstData, int secondData){
		if(firstData==secondData) return;
		if(head==null) return;
		Node first=head,second=head;
		Node prev_first=null,prev_seond=null;

		while(first!=null && first.data!=firstData){
			prev_first=first;
			first=first.next;
		}

		while(second!=null && second.data!=secondData){
			prev_seond=second;
			second=second.next;
		}

		if(first==null || second ==null){
			return;
		}
		if(null!=prev_first){
			prev_first.next=second;
		}else{
			head=first;
		}
		if(null!=prev_seond){
			prev_seond.next=first;
		}else{
			head=second;
		}
		Node temp;
		temp=first.next;
		first.next=second.next;
		second.next=temp;
		return;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.push(0);
		list.push(1);
		list.push(2);
		list.push(3);
		list.push(4);
		list.append(5);
		list.append(6);
		list.append(7);
		list.append(8);
		list.printList();
		list.deletePosition(1);
		list.printList();
		list.deleteKey(0);
		list.printList();
	}

}

package practice;

import java.util.Hashtable;

public class SingleLL {
	static class Node {
		public int data;
		public Node next;
	}

	private Node head;

	public boolean isEmpty() {
		return head == null;
	}

	// Add node at the start
	public void addFirst(int data) {
		Node cnode = new Node();
		cnode.data = data;
		cnode.next = head;
		head = cnode;
	}

	// Add node at the end
	public void addLast(int data) {
		Node cnode = head;
		if (cnode == null) {
			addFirst(data);
		} else {
			while (cnode.next != null) {
				cnode = cnode.next;
			}
			Node n = new Node();
			n.data = data;
			cnode.next = n;
		}
	}

	// Add node at particular position
	public void insertAfter(int data, int position) {
		Node cnode = head;
		Node n = new Node();
		if (position == 0) {
			n.data = data;
			n.next = cnode;
		} else {
			for (int i = 0; i < position - 1; i++) {
				cnode = cnode.next;
			}
			n.data = data;
			n.next = cnode.next;
			cnode.next = n;
		}
	}

	// Delete first node
	public void deleteFirst() {
		head = head.next;
	}

	// Delete last node
	public void deleteLast() {
		Node cnode = head;
		Node pnode = null;
		if (head == null) {
			return;
		}
		while (cnode.next != null) {
			pnode = cnode;
			cnode = cnode.next;
		}
		pnode.next = null;
	}

	// Delete node at particular position
	public void deleteAtPosition(int position) {
		Node cnode = head;
		if (cnode == null) {
			return;
		}
		if (position == 0) {
			deleteFirst();
		} else {
			for (int i = 0; i < position - 1; i++) {
				cnode = cnode.next;
			}
			if (cnode == null || cnode.next == null)
				return;
			cnode.next = cnode.next.next;
		}
	}

	// Delete particular node with specific data
	public void deleteData(Node deleteNode) {
		Node cnode = head;
		if (head == null)
			return;
		if (head.data == deleteNode.data)
			deleteFirst();
		else {
			while (cnode.next != null) {
				if (cnode.next.data == deleteNode.data) {
					cnode.next = cnode.next.next;
					return;
				}
				cnode = cnode.next;
			}
		}
	}

	// Display the node
	public void display() {
		Node cnode = head;
		while (cnode != null) {
			System.out.println(cnode.data);
			cnode = cnode.next;
		}
	}
	
	public void deleteDups(){
		Node cnode=head;
		Hashtable h = new Hashtable();
		Node previous=null;
		while(cnode!=null){
			if(h.containsKey(cnode.data)){
				previous.next=cnode.next;
			}
			else{
				h.put(cnode.data, true);
				previous=cnode;
			}
			cnode=cnode.next;
		}
	}
	
	public void deleteDups2(){
		Node pnode=head;
		Node cnode=pnode.next;
		while(cnode!=null){
			Node rnode=head;
			while(rnode!=cnode){
			if(rnode.data==cnode.data){
				rnode.next=cnode.next;
				cnode=cnode.next;
				break;
			}
			rnode=rnode.next;
			}
			if(rnode==cnode){
				pnode=cnode;
				cnode=cnode.next;
			}
		}
		
	}
	
	public static void main(String[] args) {
		SingleLL sl = new SingleLL();
		sl.addLast(7);
		sl.addFirst(6);
		sl.addLast(19);
		sl.addFirst(64);
		sl.addFirst(26);
		sl.insertAfter(26, 2);
		sl.insertAfter(44, 4);
		sl.addFirst(7);
		sl.display();
		System.out.println("====After deleting duplicates=====");
		//sl.deleteFirst();
		//System.out.println("After Deleting first item");
		//sl.display();
		//System.out.println("After Deleting Last item");
		//sl.deleteLast();
		//sl.display();
		//System.out.println("After Deleting at position 2 item");
		//sl.deleteAtPosition(2);
		//sl.deleteAtPosition(5);
		//sl.display();
		/*Node n = new Node();
		n.data = 6;
		sl.deleteData(n);
		Node n1 = new Node();
		n1.data = 21;
		sl.deleteData(n1);*/
		sl.deleteDups();
		//System.out.println("After Deleting at position 33 data");
		sl.display();
	}
}
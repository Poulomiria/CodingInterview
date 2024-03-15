package LinkedList;

public class ReverseLinkedList {
	
	public static Node reverse(Node head)
	{
		Node current = null;
		Node prev = null;
		Node next = null;
		current = head;
		while(current != null)
		{
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
		return prev;
		
	}
	public static Node reverseDLL(Node head)
	{
		Node current = null;
		Node prev = null;
		Node next = null;
		current = head;
		while(current != null)
		{
			prev = current.prev;
			current.prev = current.next;
			current.next = prev;
			current = current.prev;
		}
		return prev.prev;
	}
}

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
	static void printList(Node head)
    {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
	public static void main(String[] args)
    {
        Node head = new Node(7);
        Node temp = head;
        temp.next = new Node(10);
        temp = temp.next;
        temp.next = new Node(5);
        temp = temp.next;
        temp.next = new Node(20);
        temp = temp.next;
        temp.next = new Node(3);
        temp = temp.next;
        temp.next = new Node(2);
        temp = temp.next;
 
        // Apply merge Sort
        head = reverse(head);
        System.out.print("\nReversed Linked List is: \n");
        printList(head);
    }
			

}

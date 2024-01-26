package LinkedList;

public class LinkedList {

    static void printList(Node head)
    {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    static int lengthLL(Node head)
    {
        if(head == null) return;
        Node current = head;
        int count =0;
        while(current != null)
        {
            count++;
            current = current.next;
        }
        return count;
    }
    int getMiddle(Node head)
    {
        // Your code here.
        if(head == null)
            return 0;
        Node fast = head;
        Node slow = head;
        Node curr = head;
        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        int result = slow.data;
        return result;
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
        lengthLL(head);
    }

}

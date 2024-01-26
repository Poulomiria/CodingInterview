package LinkedList;

public class InsertionAndDeletion{

    static void insertAtBegin(int data, Node head)
    {
        Node n = new Node(data);
        n.next = head;
        head = n;
    }
    static void insertAtKth(int data, int k, Node head)
    {
        Node n = new Node(data);
        Node current = head;
        int i =0;
        if(head == null)
            return;
        while(current != null)
        {
            if(i == k)
            {
                Node next = current.next;
                current.next = n;
                n.next = next;
            }
            current = current.next;
            i++;
        }

    }


}
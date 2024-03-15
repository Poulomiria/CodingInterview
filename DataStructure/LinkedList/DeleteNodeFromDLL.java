package LinkedList;

public class DeleteNodeFromDLL {

    Node deleteNode(Node head,int x)
    {
        int count = 1;
        Node temp = head;
        if(x == 1)
        {
            head = head.next;
            return head;
        }
        while(temp.next != null )
        {
            if(x == count)
            {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }
            count++;
            temp = temp.next;
        }
        if(x == count)
        {
            temp.prev.next = temp.next;
        }
        return head;
    }
}
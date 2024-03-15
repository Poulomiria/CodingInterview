package LinkedList;

/*
https://leetcode.com/problems/rotate-list/description/

 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {

        ListNode first = head;
        ListNode second = head;
        //base check
        if(head==null || head.next == null)
            return head;

        int len = 0;
        //find the length as well as last node
        for(len = 1; first.next != null; len++ )
        {
            first = first.next;
        }
        //1.last node's next  is null now update with head


        first.next = head;
        //2. go to the last node and make the last node's next as null
        for(int j = 0; j < len - k%len -1 ; j++)
        {
            second = second.next;
        }
        //3. before putting place it a new node and return that node make it as new head
        ListNode newhead = second.next;

        second.next = null;
        return newhead;
    }

}
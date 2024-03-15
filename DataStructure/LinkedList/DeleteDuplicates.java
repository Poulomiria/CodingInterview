package LinkedList;
/*
https://leetcode.com/problems/remove-duplicates-from-sorted-list/

https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class DeleteDuplicates {

    //First Question

    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        if(head == null)
            return head;

        while(temp != null && temp.next != null)
        {
            if(temp.val == temp.next.val)
            {
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }

        }
        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;

        if(head.val != head.next.val){
            head.next = deleteDuplicates(head.next);
            return head;
        }

        while(head.next != null && head.val == head.next.val){
            head = head.next;
        }

        return deleteDuplicates(head.next);
    }
}
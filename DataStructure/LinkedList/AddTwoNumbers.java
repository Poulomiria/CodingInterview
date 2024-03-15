package LinkedList;
/*
https://leetcode.com/problems/add-two-numbers-ii/description/

 */
public class AddTwoNumbers {
    ListNode reverse(ListNode head)
    {
        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;
        while(current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    ListNode addNumbers(ListNode l1, ListNode l2)
    {
        ListNode temp = new ListNode(0);
        ListNode tail = temp;
        int rem = 0;
        while(l1 != null || l2 != null || rem != 0)
        {
            int firstDigit = (l1 != null)? l1.val : 0;
            int secondDigit = (l2 != null)? l2.val : 0;

            int sum = firstDigit + secondDigit + rem;
            int digit = sum%10;
            rem = sum/10;

            ListNode newNode = new ListNode(digit);
            tail.next = newNode;
            tail = tail.next;
            l1 = (l1 != null)? l1 = l1.next : null;
            l2 = (l2 != null)? l2 = l2.next : null;
        }
        ListNode result = temp.next;
        return result;


    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;

        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode result = addNumbers(l1, l2);
        return reverse(result);
    }

}
package LinkedList;
/*
https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
 */
public class MaximumTwinSum {

    public ListNode reverse(ListNode head){
        ListNode prev = null,curr = head,next = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }
    public int pairSum(ListNode head) {

        ListNode slow = head,fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = reverse(slow);


        int maxm = Integer.MIN_VALUE;

        while(slow != null){
            maxm = Math.max(maxm,slow.val+head.val);
            head = head.next;
            slow = slow.next;
        }
        return maxm;
    }
}

//Another Approach

/*
Intuition
You have to initialize a vector and put all values from list in it. After that just iterate through half of a vector and on each iteration compare sum of vals[i] and vals[len - i] with result value. (len - length of a vector)

Approach
Initialize vector.
Go through Linked List and put each value in vector. Also increment "len" variable.
Iterate through vector from 0 to len / 2 (half of a vector).
Compare sum of vals[i] and vals[len - i] with ans variable and store maximum between them.
Profit.
Complexity
Time complexity: O(n)

Space complexity: O(n)
*/
import java.util.ArrayList;

class Solution {
    public int pairSum(ListNode head) {
        int ans = 0, len = 0;
        ArrayList<Integer> vals = new ArrayList<>();

        while (head != null) {
            len++;
            vals.add(head.val);
            head = head.next;
        }

        for (int i = 0; i < len / 2; ++i) {
            ans = Math.max(ans, vals.get(i) + vals.get(len - i - 1));
        }

        return ans;
    }
}

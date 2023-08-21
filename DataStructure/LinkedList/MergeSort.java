package LinkedList;

public class MergeSort {
	
	public Node mergeSort(Node head)
	{
		if(head == null || head.next == null)
			return head;
		Node middle = middleNode(head);
		
		Node middleofnext = middle.next;
		middle.next = null;
		Node left = mergeSort(head);
		Node right = mergeSort(middleofnext);
		Node sortedlist = merged(left, right);
		return sortedlist;
		
	}
	public Node merged(Node a, Node b)
	{
		Node result = null;
		if(a==null)
			return b;
		if(b==null)
			return a;
		if(a.data <= b.data)
		{
			result = a;
			result.next = merged(a.next, b);
		}else
		{
			result = b;
			result.next = merged(a, b.next);
		}
		return result;
		
	}
	public Node middleNode(Node head)
	{
		Node fast = head;
		Node slow = head;
		
		while(slow != null && fast != null && fast.next != null)
		{
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
		
	}

}

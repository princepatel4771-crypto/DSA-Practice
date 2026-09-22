import java.util.*;

public class Main 

{

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Build test lists: [1,4,5], [1,3,4], [2,6]
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5, null)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        ListNode l3 = new ListNode(2, new ListNode(6, null));

        ListNode[] lists = { l1, l2, l3 };

        ListNode result = sol.mergeKLists(lists);

        // Print merged result
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

// Definition for singly-linked list node
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Min-heap that orders ListNodes by their val (smallest val comes out first)
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Push the head node of every list into the heap
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        // Dummy node to simplify building the result list
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Keep popping the smallest node until heap is empty
        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();   // get node with smallest val
            current.next = smallest;              // attach it to result list
            current = current.next;                // move pointer forward

            // If the popped node has a next node, push that into the heap too
            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }

        return dummy.next; // skip dummy, return actual head
    }
}
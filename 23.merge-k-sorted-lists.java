import java.util.*;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        // Min-Heap: hamesha sabse chhota node upar
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val));
        
        // Har list ka pehla node heap mein daalo
        for(ListNode node : lists) {
            if(node != null) pq.add(node);
        }
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while(!pq.isEmpty()) {
            ListNode min = pq.poll();   // sabse chhota nikalo
            tail.next = min;
            tail = min;
            
            // Us list ka agla node heap mein daalo
            if(min.next != null) pq.add(min.next);
        }
        
        return dummy.next;
    }
}
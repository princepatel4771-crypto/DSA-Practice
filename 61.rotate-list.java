class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        
        // Khali list, ek hi node, ya k = 0 ho to kuch badalne ki zarurat nahi
        if(head == null || head.next == null || k == 0)
            return head;
        
        // Step 1: Length aur last node dhundo
        int n = 1;
        ListNode tail = head;
        while(tail.next != null) {
            tail = tail.next;
            n++;
        }
        
        // Step 2: Jo k n se bada hai, usse chhota kar do
        k = k % n;
        if(k == 0)
            return head;
        
        // Step 3: List ko circular bana do
        tail.next = head;
        
        // Step 4: Naya tail dhundo (n - k - 1 steps)
        ListNode newTail = head;
        for(int i = 0; i < n - k - 1; i++)
            newTail = newTail.next;
        
        // Step 5: Naya head uske baad wala node hai, circle todo
        ListNode newHead = newTail.next;
        newTail.next = null;
        
        return newHead;
    }
}
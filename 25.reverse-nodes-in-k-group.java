class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode groupPrev = dummy;
        
        while(true) {
            // k-th node dhundo
            ListNode kth = getKth(groupPrev, k);
            if(kth == null) break;   // k se kam bache, ruk jao
            
            ListNode groupNext = kth.next;
            
            // Is group ko reverse karo
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;
            while(curr != groupNext) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            
            // Group ko jodo aur aage badho
            ListNode newGroupPrev = groupPrev.next;  // ab ye group ka tail hai
            groupPrev.next = kth;
            groupPrev = newGroupPrev;
        }
        
        return dummy.next;
    }
    
    private ListNode getKth(ListNode curr, int k) {
        while(curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}
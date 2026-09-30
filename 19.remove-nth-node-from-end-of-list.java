class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        // Dummy node banao
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Do pointers banao
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        // Fast ko n+1 aage le jao
        for(int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        // Dono ko aage badhao jab tak fast null na ho
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // Nth node remove karo
        slow.next = slow.next.next;
        
        return dummy.next;
    }

    public static void main(String[] args) {
        // List banao: 1->2->3->4->5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        Solution sol = new Solution();
        ListNode result = sol.removeNthFromEnd(head, 2);
        
        // Print karo
        while(result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        // Output: 1 2 3 5
    }
}
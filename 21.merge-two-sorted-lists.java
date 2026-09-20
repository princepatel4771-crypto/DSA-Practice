class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        // Dummy node banao start ke liye
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        // Dono lists compare karo
        while(list1 != null && list2 != null) {
            
            // list1 chota hai
            if(list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        
        // Bacha hua list add karo
        if(list1 != null) curr.next = list1;
        if(list2 != null) curr.next = list2;
        
        return dummy.next;
    }
}
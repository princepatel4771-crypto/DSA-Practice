class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int left = 0, right = nums.length - 1;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            
            // Target mil gaya!
            if(nums[mid] == target) return mid;
            
            // Target right mein hai
            else if(nums[mid] < target) left = mid + 1;
            
            // Target left mein hai
            else right = mid - 1;
        }
        
        // Insert position = left
        return left;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.searchInsert(
            new int[]{1,3,5,6}, 5)); // 2
        System.out.println(sol.searchInsert(
            new int[]{1,3,5,6}, 2)); // 1
        System.out.println(sol.searchInsert(
            new int[]{1,3,5,6}, 7)); // 4
    }
}
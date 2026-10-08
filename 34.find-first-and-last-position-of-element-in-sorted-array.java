class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] result = {-1, -1};
        
        // First position dhundo
        result[0] = findFirst(nums, target);
        
        // Last position dhundo
        result[1] = findLast(nums, target);
        
        return result;
    }
    
    // First occurrence
    int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int first = -1;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            
            if(nums[mid] == target) {
                first = mid;        // Save karo
                right = mid - 1;   // Aur left mein dhundo
            }
            else if(nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return first;
    }
    
    // Last occurrence
    int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int last = -1;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            
            if(nums[mid] == target) {
                last = mid;        // Save karo
                left = mid + 1;   // Aur right mein dhundo
            }
            else if(nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return last;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(java.util.Arrays.toString(
            sol.searchRange(new int[]{5,7,7,8,8,10}, 8))); // [3,4]
        System.out.println(java.util.Arrays.toString(
            sol.searchRange(new int[]{5,7,7,8,8,10}, 6))); // [-1,-1]
        System.out.println(java.util.Arrays.toString(
            sol.searchRange(new int[]{}, 0)));              // [-1,-1]
    }
}
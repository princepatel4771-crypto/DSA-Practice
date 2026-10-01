class Solution {
    public int removeElement(int[] nums, int val) {
        
        // Pointer banao
        int k = 0;
        
        // Har element check karo
        for(int i = 0; i < nums.length; i++) {
            
            // Val se alag hai toh rakho
            if(nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] nums1 = {3,2,2,3};
        System.out.println(sol.removeElement(nums1, 3)); // 2
        
        int[] nums2 = {0,1,2,2,3,0,4,2};
        System.out.println(sol.removeElement(nums2, 2)); // 5
    }
}
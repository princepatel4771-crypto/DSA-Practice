class Solution {
    public void nextPermutation(int[] nums) {
        
        int n = nums.length;
        int i = n - 2;
        
        // Step 1: Pehla decreasing element dhundo right se
        while(i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        
        // Step 2: Usse bada element dhundo right se
        if(i >= 0) {
            int j = n - 1;
            while(nums[j] <= nums[i]) {
                j--;
            }
            // Swap karo
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        
        // Step 3: Right part reverse karo
        int left = i + 1, right = n - 1;
        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] nums1 = {1, 2, 3};
        sol.nextPermutation(nums1);
        System.out.println(java.util.Arrays.toString(nums1)); // [1,3,2]
        
        int[] nums2 = {3, 2, 1};
        sol.nextPermutation(nums2);
        System.out.println(java.util.Arrays.toString(nums2)); // [1,2,3]
        
        int[] nums3 = {1, 1, 5};
        sol.nextPermutation(nums3);
        System.out.println(java.util.Arrays.toString(nums3)); // [1,5,1]
    }
}
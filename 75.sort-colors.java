class Solution {
    public void sortColors(int[] nums) {
        
        // Teen pointers:
        // low  → 0 ki next position (0 ka region shuru se)
        // mid  → current element
        // high → 2 ki pehli position (2 ka region end se)
        int low = 0, mid = 0, high = nums.length - 1;
        
        while(mid <= high) {
            if(nums[mid] == 0) {
                // 0 hai, low wali jagah pe bhejo
                swap(nums, low, mid);
                low++;
                mid++;
            }
            else if(nums[mid] == 1) {
                // 1 hai, bas aage badho
                mid++;
            }
            else {
                // 2 hai, high wali jagah pe bhejo
                // mid ko aage nahi badhate, kyunki swap wali value abhi check karni hai
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] a = {2,0,2,1,1,0};
        sol.sortColors(a);
        System.out.println(java.util.Arrays.toString(a)); // [0, 0, 1, 1, 2, 2]
        
        int[] b = {2,0,1};
        sol.sortColors(b);
        System.out.println(java.util.Arrays.toString(b)); // [0, 1, 2]
    }
}
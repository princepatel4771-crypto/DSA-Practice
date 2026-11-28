class Solution {
    public int removeDuplicates(int[] nums) {
        
        // k = wo index jahan next valid element likhna hai
        int k = 0;
        
        for(int num : nums) {
            // Pehle 2 elements hamesha allowed hain
            // Uske baad sirf wahi lo jo k-2 wale element se alag ho
            // (sorted hai, to k-2 wala check kaafi hai)
            if(k < 2 || num != nums[k - 2]) {
                nums[k] = num;
                k++;
            }
        }
        
        return k;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] a = {1,1,1,2,2,3};
        int len = sol.removeDuplicates(a);
        System.out.println(len);                                   // 5
        System.out.println(java.util.Arrays.toString(
            java.util.Arrays.copyOf(a, len)));                     // [1, 1, 2, 2, 3]
        
        int[] b = {0,0,1,1,1,1,2,3,3};
        len = sol.removeDuplicates(b);
        System.out.println(len);                                   // 7
        System.out.println(java.util.Arrays.toString(
            java.util.Arrays.copyOf(b, len)));                     // [0, 0, 1, 1, 2, 3, 3]
    }
}
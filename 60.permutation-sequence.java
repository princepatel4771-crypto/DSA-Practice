import java.util.*;

class Solution {
    public String getPermutation(int n, int k) {
        
        // Available numbers: 1, 2, ..., n
        List<Integer> nums = new ArrayList<>();
        for(int i = 1; i <= n; i++)
            nums.add(i);
        
        // fact[i] = i!
        int[] fact = new int[n];
        fact[0] = 1;
        for(int i = 1; i < n; i++)
            fact[i] = fact[i - 1] * i;
        
        k--;  // 0-indexed karo
        StringBuilder sb = new StringBuilder();
        
        for(int i = n; i >= 1; i--) {
            // Kitne blocks skip karne hain? (har block = (i-1)! permutations)
            int idx = k / fact[i - 1];
            sb.append(nums.remove(idx));
            k %= fact[i - 1];
        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.getPermutation(3, 3)); // 213
        System.out.println(sol.getPermutation(4, 9)); // 2314
        System.out.println(sol.getPermutation(3, 1)); // 123
    }
}
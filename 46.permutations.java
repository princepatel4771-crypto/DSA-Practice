import java.util.*;

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }
    
    void backtrack(int[] nums, List<Integer> current, boolean[] used) {
        
        // Base case - poora permutation ban gaya!
        if(current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            
            // Already use kiya hai toh skip
            if(used[i]) continue;
            
            // Add karo
            current.add(nums[i]);
            used[i] = true;
            
            // Aage badhao
            backtrack(nums, current, used);
            
            // Wapas hatao
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.permute(new int[]{1,2,3}));
        // [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        
        System.out.println(sol.permute(new int[]{0,1}));
        // [[0,1],[1,0]]
    }
}
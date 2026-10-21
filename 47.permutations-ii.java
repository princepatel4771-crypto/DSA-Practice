import java.util.*;

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums); // Sort karo pehle
        backtrack(nums, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }
    
    void backtrack(int[] nums, List<Integer> current, boolean[] used) {
        
        // Base case
        if(current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            
            // Already used
            if(used[i]) continue;
            
            // Duplicate skip karo
            if(i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            
            current.add(nums[i]);
            used[i] = true;
            
            backtrack(nums, current, used);
            
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.permuteUnique(new int[]{1,1,2}));
        // [[1,1,2],[1,2,1],[2,1,1]]
        
        System.out.println(sol.permuteUnique(new int[]{1,2,3}));
        // [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    }
}
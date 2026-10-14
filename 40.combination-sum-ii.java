import java.util.*;

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // Sort karo pehle
        backtrack(candidates, target, 0, new ArrayList<>());
        return result;
    }
    
    void backtrack(int[] candidates, int target, 
                   int start, List<Integer> current) {
        
        // Base case - target mil gaya!
        if(target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for(int i = start; i < candidates.length; i++) {
            
            // Target se bada hai toh band karo
            if(candidates[i] > target) break;
            
            // Duplicate skip karo
            if(i > start && candidates[i] == candidates[i-1]) continue;
            
            // Current mein add karo
            current.add(candidates[i]);
            
            // Aage badhao - i+1 kyunki same element use nahi kar sakte
            backtrack(candidates, target - candidates[i], 
                     i + 1, current);
            
            // Wapas hatao
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.combinationSum2(
            new int[]{10,1,2,7,6,1,5}, 8));
        // [[1,1,6],[1,2,5],[1,7],[2,6]]
        
        System.out.println(sol.combinationSum2(
            new int[]{2,5,2,1,2}, 5));
        // [[1,2,2],[5]]
    }
}
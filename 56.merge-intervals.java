import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        
        // Step 1: Start time ke hisaab se sort karo
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        
        for(int i = 1; i < intervals.length; i++) {
            
            // Overlap hai? (next ka start <= current ka end)
            if(intervals[i][0] <= current[1]) {
                // Merge karo: end ko bada wala bana do
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                // Overlap nahi, current ko save karo, naya shuru karo
                result.add(current);
                current = intervals[i];
            }
        }
        
        // Aakhri interval add karna mat bhoolna
        result.add(current);
        
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(Arrays.deepToString(sol.merge(
            new int[][]{{1,3},{2,6},{8,10},{15,18}})));
        // [[1, 6], [8, 10], [15, 18]]
        
        System.out.println(Arrays.deepToString(sol.merge(
            new int[][]{{1,4},{4,5}})));
        // [[1, 5]]
    }
}
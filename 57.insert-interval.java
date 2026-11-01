import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        
        // Phase 1: Jo intervals newInterval se PEHLE khatam ho gaye
        while(i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        
        // Phase 2: Jo newInterval se OVERLAP kar rahe hain, unhe merge karo
        while(i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);
        
        // Phase 3: Baaki bache hue intervals (newInterval ke BAAD wale)
        while(i < n) {
            result.add(intervals[i]);
            i++;
        }
        
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(Arrays.deepToString(sol.insert(
            new int[][]{{1,3},{6,9}}, new int[]{2,5})));
        // [[1, 5], [6, 9]]
        
        System.out.println(Arrays.deepToString(sol.insert(
            new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8})));
        // [[1, 2], [3, 10], [12, 16]]
    }
}
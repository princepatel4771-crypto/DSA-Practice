class Solution {
    public int minPathSum(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        // dp[j] = column j tak pahunchne ka minimum sum (is row mein)
        int[] dp = new int[n];
        
        // Pehli row: sirf left se aa sakte hain
        dp[0] = grid[0][0];
        for(int j = 1; j < n; j++)
            dp[j] = dp[j - 1] + grid[0][j];
        
        // Baaki rows
        for(int i = 1; i < m; i++) {
            // Pehla column: sirf upar se aa sakte hain
            dp[0] += grid[i][0];
            
            for(int j = 1; j < n; j++) {
                // upar (dp[j]) ya left (dp[j-1]), jo chhota ho
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }
        
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.minPathSum(
            new int[][]{{1,3,1},{1,5,1},{4,2,1}})); // 7
        System.out.println(sol.minPathSum(
            new int[][]{{1,2,3},{4,5,6}}));         // 12
    }
}
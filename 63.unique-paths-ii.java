
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        // dp[j] = is row mein column j tak pahunchne ke raaste
        int[] dp = new int[n];
        
        // Start cell pe obstacle ho to 0 raaste
        dp[0] = (obstacleGrid[0][0] == 0) ? 1 : 0;
        
        // Pehli row
        for(int j = 1; j < n; j++) {
            if(obstacleGrid[0][j] == 1) dp[j] = 0;   // obstacle, yahan se aage nahi ja sakte
            else dp[j] = dp[j - 1];                    // left se aaye
        }
        
        // Baaki rows
        for(int i = 1; i < m; i++) {
            // Pehla column
            if(obstacleGrid[i][0] == 1) dp[0] = 0;
            
            for(int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 1) dp[j] = 0;  // obstacle: 0 raaste
                else dp[j] += dp[j - 1];                  // upar + left
            }
        }
        
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.uniquePathsWithObstacles(
            new int[][]{{0,0,0},{0,1,0},{0,0,0}})); // 2
        System.out.println(sol.uniquePathsWithObstacles(
            new int[][]{{0,1},{0,0}}));             // 1
        System.out.println(sol.uniquePathsWithObstacles(
            new int[][]{{1}}));                     // 0
    }
}
class Solution {
    public int uniquePaths(int m, int n) {
        
        // dp[j] = is row mein column j tak pahunchne ke raaste
        int[] dp = new int[n];
        Arrays.fill(dp, 1);   // pehli row: sab cells mein 1 hi raasta
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                // upar se aaye (dp[j]) + left se aaye (dp[j-1])
                dp[j] += dp[j - 1];
            }
        }
        
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.uniquePaths(3, 7)); // 28
        System.out.println(sol.uniquePaths(3, 2)); // 3
        System.out.println(sol.uniquePaths(1, 1)); // 1
    }
}
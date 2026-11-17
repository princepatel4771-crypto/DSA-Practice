class Solution {
    public int minDistance(String word1, String word2) {
        
        int m = word1.length();
        int n = word2.length();
        
        // dp[i][j] = word1 ke pehle i chars ko word2 ke pehle j chars mein badalne ka minimum cost
        int[][] dp = new int[m + 1][n + 1];
        
        // Base case: khali string se word2 banane ke liye j inserts
        for(int j = 0; j <= n; j++) dp[0][j] = j;
        
        // Base case: word1 ko khali karne ke liye i deletes
        for(int i = 0; i <= m; i++) dp[i][0] = i;
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // Last characters same hain, kuch extra nahi karna
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Teen mein se best operation lo
                    dp[i][j] = 1 + Math.min(
                        dp[i - 1][j - 1],   // replace
                        Math.min(
                            dp[i - 1][j],   // delete
                            dp[i][j - 1]    // insert
                        )
                    );
                }
            }
        }
        
        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.minDistance("horse", "ros"));        // 3
        System.out.println(sol.minDistance("intention", "execution")); // 5
    }
}
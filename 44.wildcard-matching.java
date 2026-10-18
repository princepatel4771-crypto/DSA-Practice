class Solution {
    public boolean isMatch(String s, String p) {
        
        int m = s.length(), n = p.length();
        
        // DP table banao
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Empty string empty pattern se match karta hai
        dp[0][0] = true;
        
        // Pattern mein * hai toh empty string match ho sakti hai
        for(int j = 1; j <= n; j++) {
            if(p.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j-1];
            }
        }
        
        // Fill karo
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                
                char sc = s.charAt(i-1);
                char pc = p.charAt(j-1);
                
                if(pc == '*') {
                    // * = empty ya kuch bhi
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
                else if(pc == '?' || sc == pc) {
                    // ? = koi bhi ek character
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        
        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.isMatch("aa", "a"));    // false
        System.out.println(sol.isMatch("aa", "*"));    // true
        System.out.println(sol.isMatch("cb", "?a"));   // false
        System.out.println(sol.isMatch("adceb", "*a*b")); // true
    }
}
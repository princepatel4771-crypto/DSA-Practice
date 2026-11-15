class Solution {
    public int climbStairs(int n) {
        
        // Base cases: 1 step ke 1 tareeka, 2 steps ke 2 tareeke
        if(n <= 2) return n;
        
        int prev2 = 1;   // n-2 steps tak pahunchne ke tareeke
        int prev1 = 2;   // n-1 steps tak pahunchne ke tareeke
        
        for(int i = 3; i <= n; i++) {
            int curr = prev1 + prev2;   // aakhri step 1 ya 2 ka ho sakta hai
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.climbStairs(2)); // 2
        System.out.println(sol.climbStairs(3)); // 3
        System.out.println(sol.climbStairs(5)); // 8
    }
}
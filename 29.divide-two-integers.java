class Solution {
    public int divide(int dividend, int divisor) {
        
        // Overflow case
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        
        // Sign check
        int sign = (dividend > 0) == (divisor > 0) ? 1 : -1;
        
        // Positive mein convert
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        
        // Simple division
        long result = a / b;
        
        return (int)(sign == 1 ? result : -result);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.divide(10, 3));  // 3
        System.out.println(sol.divide(7, -2));  // -3
    }
}
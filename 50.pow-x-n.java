class Solution {
    public double myPow(double x, int n) {
        long N = (long) n;
        if(N < 0) {
            x = 1.0 / x;
            N = -N;
        }
        double result = 1.0;
        while(N > 0) {
            if((N & 1) == 1) {
                result *= x;
            }
            x *= x;
            N >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.myPow(2.00000, 10));   // 1024.0
        System.out.println(sol.myPow(2.10000, 3));    // 9.261
        System.out.println(sol.myPow(2.00000, -2));   // 0.25
    }
}
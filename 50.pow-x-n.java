public class Solution {
    public double myPow(double x, int n) {
        long N = (long) n;
        
        // Agar power negative hai, positive banao
        if (N < 0) {
            N = -N;
        }

        double result = 1.0;
        double currentProduct = x;

        // Binary Exponentiation
        while (N > 0) {
            if ((N & 1) == 1) {
                result *= currentProduct;
            }
            currentProduct *= currentProduct;
            N >>= 1;
        }

        // Division end me sirf ek baar karo precision preserve karne ke liye
        return (n < 0) ? (1.0 / result) : result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Failed test case verification:
        double x = -0.9999999968539456;
        int n = -1669585506;
        System.out.printf("Output: %.5f\n", sol.myPow(x, n)); 
        // Expected: 191.06370
    }
}
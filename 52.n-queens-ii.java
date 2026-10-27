class Solution {
    int count = 0;
    
    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n];
        boolean[] diag2 = new boolean[2 * n];
        solve(0, n, cols, diag1, diag2);
        return count;
    }
    
    void solve(int row, int n, boolean[] cols, 
               boolean[] diag1, boolean[] diag2) {
        
        // Base case - sab rows fill ho gayi
        if(row == n) {
            count++;
            return;
        }
        
        for(int col = 0; col < n; col++) {
            
            // Check karo safe hai?
            if(cols[col] || diag1[row - col + n] || diag2[row + col])
                continue;
            
            // Place karo
            cols[col] = true;
            diag1[row - col + n] = true;
            diag2[row + col] = true;
            
            solve(row + 1, n, cols, diag1, diag2);
            
            // Wapas hatao
            cols[col] = false;
            diag1[row - col + n] = false;
            diag2[row + col] = false;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.totalNQueens(4)); // 2
        System.out.println(sol.totalNQueens(1)); // 1
    }
}
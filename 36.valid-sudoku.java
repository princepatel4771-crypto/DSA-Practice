class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        // Sets banao rows, cols, boxes ke liye
        java.util.Set<String> seen = new java.util.HashSet<>();
        
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                
                char num = board[i][j];
                if(num == '.') continue; // empty cell skip
                
                // Row check
                String row = num + " in row " + i;
                // Col check
                String col = num + " in col " + j;
                // Box check (3x3)
                String box = num + " in box " + i/3 + j/3;
                
                // Agar pehle se hai toh invalid!
                if(!seen.add(row) || 
                   !seen.add(col) || 
                   !seen.add(box)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        
        System.out.println(sol.isValidSudoku(board)); // true
    }
}
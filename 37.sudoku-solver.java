class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    boolean solve(char[][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                
                // Empty cell mila
                if(board[i][j] == '.') {
                    
                    // 1-9 try karo
                    for(char c = '1'; c <= '9'; c++) {
                        
                        // Valid hai toh place karo
                        if(isValid(board, i, j, c)) {
                            board[i][j] = c;
                            
                            // Aage solve karo
                            if(solve(board)) return true;
                            
                            // Nahi hua toh wapas khali karo
                            board[i][j] = '.';
                        }
                    }
                    return false; // koi number nahi chala
                }
            }
        }
        return true; // sab fill ho gaya!
    }
    
    boolean isValid(char[][] board, int row, int col, char c) {
        
        for(int i = 0; i < 9; i++) {
            
            // Row check
            if(board[row][i] == c) return false;
            
            // Col check
            if(board[i][col] == c) return false;
            
            // 3x3 box check
            if(board[3*(row/3) + i/3][3*(col/3) + i%3] == c) 
                return false;
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
        sol.solveSudoku(board);
        for(char[] row : board)
            System.out.println(new String(row));
    }
}
class Solution {
    public boolean exist(char[][] board, String word) {
        
        // Har cell ko shuruaat maan ke check karo
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int k) {
        
        // Poora word mil gaya
        if(k == word.length()) return true;
        
        // Board ke bahar, ya character match nahi hua
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return false;
        if(board[i][j] != word.charAt(k))
            return false;
        
        // Is cell ko visited mark karo, taaki wapas use na ho
        char temp = board[i][j];
        board[i][j] = '#';
        
        // Chaaron direction mein aage badho
        boolean found = dfs(board, word, i + 1, j, k + 1)
                     || dfs(board, word, i - 1, j, k + 1)
                     || dfs(board, word, i, j + 1, k + 1)
                     || dfs(board, word, i, j - 1, k + 1);
        
        // Backtrack: cell ko wapas original value do
        board[i][j] = temp;
        
        return found;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        char[][] board1 = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}};
        System.out.println(sol.exist(board1, "ABCCED")); // true
        System.out.println(sol.exist(board1, "SEE"));    // true
        System.out.println(sol.exist(board1, "ABCB"));   // false
    }
}
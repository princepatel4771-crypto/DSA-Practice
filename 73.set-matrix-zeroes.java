import java.util.*;

class Solution {
    public void setZeroes(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Step 1: Check karo ki pehli row aur pehla column mein zero hai ya nahi
        boolean firstRowZero = false;
        boolean firstColZero = false;
        
        for(int j = 0; j < n; j++)
            if(matrix[0][j] == 0) firstRowZero = true;
        
        for(int i = 0; i < m; i++)
            if(matrix[i][0] == 0) firstColZero = true;
        
        // Step 2: Baaki matrix mein zero dhoondho, aur uske marker
        // pehli row aur pehle column mein likh do
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;   // is row ka marker
                    matrix[0][j] = 0;   // is column ka marker
                }
            }
        }
        
        // Step 3: Markers ke hisaab se cells ko zero karo
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }
        
        // Step 4: Pehli row aur pehla column, agar pehle zero the to zero karo
        if(firstRowZero)
            for(int j = 0; j < n; j++) matrix[0][j] = 0;
        
        if(firstColZero)
            for(int i = 0; i < m; i++) matrix[i][0] = 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[][] a = {{1,1,1},{1,0,1},{1,1,1}};
        sol.setZeroes(a);
        System.out.println(Arrays.deepToString(a));
        // [[1, 0, 1], [0, 0, 0], [1, 0, 1]]
        
        int[][] b = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        sol.setZeroes(b);
        System.out.println(Arrays.deepToString(b));
        // [[0, 0, 0, 0], [0, 4, 5, 0], [0, 3, 1, 0]]
    }
}
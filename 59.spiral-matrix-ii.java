class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] matrix = new int[n][n];
        
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        int num = 1;
        
        while(top <= bottom && left <= right) {
            
            // 1. Left → Right (upar wali row)
            for(int i = left; i <= right; i++)
                matrix[top][i] = num++;
            top++;
            
            // 2. Top → Bottom (right wali column)
            for(int i = top; i <= bottom; i++)
                matrix[i][right] = num++;
            right--;
            
            // 3. Right → Left (neeche wali row)
            if(top <= bottom) {
                for(int i = right; i >= left; i--)
                    matrix[bottom][i] = num++;
                bottom--;
            }
            
            // 4. Bottom → Top (left wali column)
            if(left <= right) {
                for(int i = bottom; i >= top; i--)
                    matrix[i][left] = num++;
                left++;
            }
        }
        
        return matrix;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(Arrays.deepToString(sol.generateMatrix(3)));
        // [[1, 2, 3], [8, 9, 4], [7, 6, 5]]
        
        System.out.println(Arrays.deepToString(sol.generateMatrix(1)));
        // [[1]]
    }
}
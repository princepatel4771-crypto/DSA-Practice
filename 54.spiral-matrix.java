import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        
        while(top <= bottom && left <= right) {
            
            // 1. Left → Right (upar wali row)
            for(int i = left; i <= right; i++)
                result.add(matrix[top][i]);
            top++;
            
            // 2. Top → Bottom (right wali column)
            for(int i = top; i <= bottom; i++)
                result.add(matrix[i][right]);
            right--;
            
            // 3. Right → Left (neeche wali row)
            if(top <= bottom) {
                for(int i = right; i >= left; i--)
                    result.add(matrix[bottom][i]);
                bottom--;
            }
            
            // 4. Bottom → Top (left wali column)
            if(left <= right) {
                for(int i = bottom; i >= top; i--)
                    result.add(matrix[i][left]);
                left++;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.spiralOrder(new int[][]{
            {1,2,3},
            {4,5,6},
            {7,8,9}}));
        // [1, 2, 3, 6, 9, 8, 7, 4, 5]
        
        System.out.println(sol.spiralOrder(new int[][]{
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12}}));
        // [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
    }
}
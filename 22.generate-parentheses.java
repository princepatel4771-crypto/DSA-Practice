import java.util.*;

class Solution {
    List<String> result = new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
        backtrack("", 0, 0, n);
        return result;
    }
    
    void backtrack(String curr, int open, int close, int n) {
        
        // Base case - poora combination ban gaya
        if(curr.length() == 2 * n) {
            result.add(curr);
            return;
        }
        
        // Opening bracket add karo
        if(open < n) {
            backtrack(curr + "(", open + 1, close, n);
        }
        
        // Closing bracket add karo
        if(close < open) {
            backtrack(curr + ")", open, close + 1, n);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.generateParenthesis(3));
        // ["((()))","(()())","(())()","()(())","()()()"]
        
        System.out.println(sol.generateParenthesis(1));
        // ["()"]
    }
}

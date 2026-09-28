import java.util.*;

class Solution {
    
    // Phone keypad mapping
    String[] keypad = {"", "", "abc", "def", "ghi", "jkl", 
                       "mno", "pqrs", "tuv", "wxyz"};
    
    List<String> result = new ArrayList<>();
    
    public List<String> letterCombinations(String digits) {
        
        // Empty check
        if(digits.isEmpty()) return result;
        
        // Backtracking start karo
        backtrack("", digits, 0);
        return result;
    }
    
    void backtrack(String curr, String digits, int index) {
        
        // Base case — poora combination ban gaya
        if(index == digits.length()) {
            result.add(curr);
            return;
        }
        
        // Current digit ke letters
        String letters = keypad[digits.charAt(index) - '0'];
        
        // Har letter ke liye try karo
        for(char c : letters.toCharArray()) {
            backtrack(curr + c, digits, index + 1);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.letterCombinations("23")); 
        // [ad,ae,af,bd,be,bf,cd,ce,cf]
    }
}
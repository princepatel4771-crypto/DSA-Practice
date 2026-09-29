import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        
        List<String> result = new ArrayList<>();
        
        // Empty check
        if(digits == null || digits.isEmpty()) return result;
        
        // Phone keypad mapping
        String[] keypad = {"", "", "abc", "def", "ghi", 
                          "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        // Backtracking
        backtrack(result, "", digits, 0, keypad);
        return result;
    }
    
    void backtrack(List<String> result, String curr, 
                   String digits, int index, String[] keypad) {
        
        // Base case
        if(index == digits.length()) {
            result.add(curr);
            return;
        }
        
        // Current digit ke letters
        String letters = keypad[digits.charAt(index) - '0'];
        
        // Har letter try karo
        for(char c : letters.toCharArray()) {
            backtrack(result, curr + c, digits, index + 1, keypad);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.letterCombinations("23"));
        // [ad,ae,af,bd,be,bf,cd,ce,cf]
        System.out.println(sol.letterCombinations("2"));
        // [a,b,c]
    }
}
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        
        // Stack banao brackets store karne ke liye
        Stack<Character> stack = new Stack<>();
        
        // Har character check karo
        for(char c : s.toCharArray()) {
            
            // Opening brackets → stack mein daalo
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            
            // Closing brackets → match karo
            else {
                // Stack khali hai → invalid
                if(stack.isEmpty()) return false;
                
                char top = stack.pop();
                
                // Match nahi kiya → invalid
                if(c == ')' && top != '(') return false;
                if(c == '}' && top != '{') return false;
                if(c == ']' && top != '[') return false;
            }
        }
        
        // Stack khali honi chahiye end mein
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isValid("()"));     // true
        System.out.println(sol.isValid("()[]{}")); // true
        System.out.println(sol.isValid("(]"));     // false
        System.out.println(sol.isValid("([)]"));   // false

    }
}
import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Base boundary index
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    // Agar stack khali ho gaya, current index naya base banega
                    stack.push(i);
                } else {
                    // Valid substring length = current index - stack top index
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Cases
        String s1 = "(()";
        String s2 = ")()())";
        String s3 = "";

        System.out.println("Test Case 1: " + sol.longestValidParentheses(s1)); // Output: 2
        System.out.println("Test Case 2: " + sol.longestValidParentheses(s2)); // Output: 4
        System.out.println("Test Case 3: " + sol.longestValidParentheses(s3)); // Output: 0
    }
}
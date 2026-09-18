class Solution {
    public int myAtoi(String s) {
        
        // Step 1: Spaces hatao shuru aur end se
        s = s.trim();
        
        // Step 2: Agar string khali hai toh 0 return karo
        if(s.isEmpty()) return 0;
        
        // Step 3: Sign aur position track karne ke liye
        int sign = 1;  // default positive
        int i = 0;     // current position
        long result = 0; // answer store karega
        
        // Step 4: Pehla character check karo
        if(s.charAt(0) == '-') { 
            sign = -1;  // negative number hai
            i++;        // aage badho
        } else if(s.charAt(0) == '+') { 
            i++;        // positive hai, aage badho
        }
        
        // Step 5: Jab tak digit hai tab tak loop chalao
        while(i < s.length() && Character.isDigit(s.charAt(i))) {
            
            // Digit by digit number banao
            // "123" → 1 → 12 → 123
            result = result * 10 + (s.charAt(i) - '0');
            
            // Step 6: Overflow check karo
            // Number bahut bada ho gaya
            if(result * sign > Integer.MAX_VALUE) 
                return Integer.MAX_VALUE;
            
            // Number bahut chota ho gaya    
            if(result * sign < Integer.MIN_VALUE) 
                return Integer.MIN_VALUE;
            
            i++; // agle digit pe jao
        }
        
        // Step 7: Final answer return karo sign ke saath
        return (int)(result * sign);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.myAtoi("42"));      // 42
        System.out.println(sol.myAtoi("-42"));     // -42
        System.out.println(sol.myAtoi("4193 with words")); // 4193
    }
}
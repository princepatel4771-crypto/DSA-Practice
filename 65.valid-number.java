class Solution {
    public boolean isNumber(String s) {
        
        s = s.trim();   // leading/trailing spaces allowed hain
        
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExp = false;
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(Character.isDigit(c)) {
                seenDigit = true;
            }
            else if(c == '.') {
                // Dot sirf ek baar, aur exponent se pehle
                if(seenDot || seenExp) return false;
                seenDot = true;
            }
            else if(c == 'e' || c == 'E') {
                // Exponent se pehle digit zaroori, aur ek hi baar
                if(seenExp || !seenDigit) return false;
                seenExp = true;
                seenDigit = false;   // exponent ke baad digit zaroori
            }
            else if(c == '+' || c == '-') {
                // Sign sirf shuru mein ya 'e' ke turant baad
                if(i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')
                    return false;
            }
            else {
                return false;   // koi aur character allowed nahi
            }
        }
        
        // Aakhir mein kam se kam ek digit hona chahiye
        return seenDigit;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.isNumber("0"));       // true
        System.out.println(sol.isNumber("e"));       // false
        System.out.println(sol.isNumber(".")); // false
        System.out.println(sol.isNumber("2e10"));    // true
        System.out.println(sol.isNumber("-.5"));     // true
        System.out.println(sol.isNumber("3."));      // true
        System.out.println(sol.isNumber("abc"));     // false
    }
}
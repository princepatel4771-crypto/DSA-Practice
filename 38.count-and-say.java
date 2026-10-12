class Solution {
    public String countAndSay(int n) {
        // Base case
        if (n == 1) {
            return "1";
        }
        
        String current = "1";
        
        // n-1 times sequence ko build karenge
        for (int i = 2; i <= n; i++) {
            StringBuilder nextSeq = new StringBuilder();
            int count = 1;
            
            // Current string ko traverse karke consecutive characters count karenge
            for (int j = 1; j < current.length(); j++) {
                if (current.charAt(j) == current.charAt(j - 1)) {
                    count++;
                } else {
                    // Jab character change ho, count aur pichla character append karo
                    nextSeq.append(count).append(current.charAt(j - 1));
                    count = 1; // reset count
                }
            }
            
            // Loop khatam hone ke baad aakhri character group ko append karo
            nextSeq.append(count).append(current.charAt(current.length() - 1));
            
            current = nextSeq.toString();
        }
        
        return current;
    }
}
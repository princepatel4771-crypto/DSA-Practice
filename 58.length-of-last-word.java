class Solution {
    public int lengthOfLastWord(String s) {
        
        int i = s.length() - 1;
        
        // Step 1: Peeche ke spaces skip karo
        while(i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        
        // Step 2: Last word ke characters count karo
        int length = 0;
        while(i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }
        
        return length;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.lengthOfLastWord("Hello World"));                // 5
        System.out.println(sol.lengthOfLastWord("   fly me   to   the moon  ")); // 4
        System.out.println(sol.lengthOfLastWord("luffy is still joyboy"));      // 6
    }
}
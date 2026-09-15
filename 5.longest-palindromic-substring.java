class Solution {
    public String longestPalindrome(String s) {
        if(s.length() < 2) return s;
        
        int start = 0, maxLen = 1;
        
        for(int i = 0; i < s.length(); i++) {
            // odd length
            int l = i, r = i;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if(r - l + 1 > maxLen) {
                    start = l;
                    maxLen = r - l + 1;
                }
                l--; r++;
            }
            
            // even length
            l = i; r = i + 1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if(r - l + 1 > maxLen) {
                    start = l;
                    maxLen = r - l + 1;
                }
                l--; r++;
            }
        }
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestPalindrome("babad")); // bab
        System.out.println(sol.longestPalindrome("cbbd"));  // bb
    }
}
class Solution {
    public int strStr(String haystack, String needle) {
        
        // Needle khali hai toh 0 return karo
        if(needle.isEmpty()) return 0;
        
        // Har position pe check karo
        for(int i = 0; i <= haystack.length() - needle.length(); i++) {
            
            // Substring match karo
            if(haystack.substring(i, i + needle.length()).equals(needle)) {
                return i; // index return karo
            }
        }
        
        // Nahi mila
        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.strStr("sadbutsad", "sad")); // 0
        System.out.println(sol.strStr("leetcode", "leeto")); // -1
    }
}
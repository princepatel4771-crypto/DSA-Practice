
class Solution {
    public String minWindow(String s, String t) {
        
        // t mein har character kitni baar chahiye
        int[] need = new int[128];
        for(char c : t.toCharArray()) need[c]++;
        
        int required = t.length();   // kitne characters abhi bhi chahiye
        int left = 0;
        int bestStart = 0, bestLen = Integer.MAX_VALUE;
        
        for(int right = 0; right < s.length(); right++) {
            char rc = s.charAt(right);
            
            // Agar ye character t mein chahiye tha, to required kam karo
            if(need[rc] > 0) required--;
            need[rc]--;   // window mein ek aur rc aaya (negative bhi ja sakta hai, jo extra hai)
            
            // Jab saare characters mil gaye, tab window ko chhota karne ki koshish karo
            while(required == 0) {
                // Best answer update karo
                if(right - left + 1 < bestLen) {
                    bestLen = right - left + 1;
                    bestStart = left;
                }
                
                // Left se ek character hatao
                char lc = s.charAt(left);
                need[lc]++;
                if(need[lc] > 0) required++;   // ab ye character zaroori ho gaya
                left++;
            }
        }
        
        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLen);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.minWindow("ADOBECODEBANC", "ABC")); // BANC
        System.out.println(sol.minWindow("a", "a"));               // a
        System.out.println(sol.minWindow("a", "aa"));              // ""
    }
}
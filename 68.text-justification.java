import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        List<String> result = new ArrayList<>();
        int i = 0;
        
        while(i < words.length) {
            
            // Step 1: Is line mein kaun se words aayenge?
            int lineLen = words[i].length();   // words ki length + gaps
            int j = i + 1;
            while(j < words.length && lineLen + 1 + words[j].length() <= maxWidth) {
                lineLen += 1 + words[j].length();
                j++;
            }
            
            // Step 2: Line banao
            int wordCount = j - i;
            int totalChars = 0;
            for(int k = i; k < j; k++) totalChars += words[k].length();
            
            StringBuilder sb = new StringBuilder();
            
            // Last line ya ek hi word: left-justified
            if(j == words.length || wordCount == 1) {
                for(int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if(k < j - 1) sb.append(' ');
                }
                // Baaki space end mein
                while(sb.length() < maxWidth) sb.append(' ');
            }
            else {
                // Beech ke gaps barabar baanton
                int totalSpaces = maxWidth - totalChars;
                int gaps = wordCount - 1;
                int evenSpace = totalSpaces / gaps;   // har gap mein minimum space
                int extra = totalSpaces % gaps;       // bache hue space, bayein gaps se shuru

                for(int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if(k < j - 1) {
                        int spaces = evenSpace + (k - i < extra ? 1 : 0);
                        for(int s = 0; s < spaces; s++) sb.append(' ');
                    }
                }
            }
            
            result.add(sb.toString());
            i = j;
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.fullJustify(
            new String[]{"This","is","an","example","of","text","justification."}, 16));
        // [This    is    an, example  of text, justification.  ]
        
        System.out.println(sol.fullJustify(
            new String[]{"What","must","be","acknowledgment","shall","be"}, 16));
        // [What   must   be, acknowledgment  , shall be        ]
    }
}
import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
        List<Integer> result = new ArrayList<>();
        if(s == null || words == null || words.length == 0) 
            return result;
        
        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;
        int n = s.length();
        
        // Words frequency map
        Map<String, Integer> wordMap = new HashMap<>();
        for(String w : words) {
            wordMap.put(w, wordMap.getOrDefault(w, 0) + 1);
        }
        
        // Sliding window approach
        for(int i = 0; i < wordLen; i++) {
            
            int left = i, count = 0;
            Map<String, Integer> window = new HashMap<>();
            
            for(int j = i; j <= n - wordLen; j += wordLen) {
                
                String word = s.substring(j, j + wordLen);
                
                if(wordMap.containsKey(word)) {
                    window.put(word, window.getOrDefault(word, 0) + 1);
                    count++;
                    
                    // Zyada baar aaya toh left badhao
                    while(window.get(word) > wordMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        window.put(leftWord, window.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }
                    
                    // Sab words mile!
                    if(count == wordCount) {
                        result.add(left);
                        String leftWord = s.substring(left, left + wordLen);
                        window.put(leftWord, window.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }
                } else {
                    // Reset karo
                    window.clear();
                    count = 0;
                    left = j + wordLen;
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.findSubstring(
            "barfoothefoobarman", 
            new String[]{"foo","bar"}));     // [0, 9]
            
        System.out.println(sol.findSubstring(
            "wordgoodgoodgoodbestword",
            new String[]{"word","good","best","word"})); // []
    }
}
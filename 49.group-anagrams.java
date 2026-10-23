import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        // HashMap - sorted word → list of anagrams
        Map<String, List<String>> map = new HashMap<>();
        
        for(String word : strs) {
            
            // Word ko sort karo → key banao
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            // Map mein add karo
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(word);
        }
        
        // Groups return karo
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(sol.groupAnagrams(strs));
        // [[eat,tea,ate],[tan,nat],[bat]]
    }
}
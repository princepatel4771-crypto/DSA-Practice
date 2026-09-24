class Solution {
    public int romanToInt(String s) {
        
        // Roman values map karo
        java.util.Map<Character, Integer> map = new java.util.HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int result = 0;
        
        for(int i = 0; i < s.length(); i++) {
            int curr = map.get(s.charAt(i));
            int next = (i + 1 < s.length()) ? 
                        map.get(s.charAt(i+1)) : 0;
            
            // Agar curr next se chota hai → subtract karo
            if(curr < next) result -= curr;
            // Warna add karo
            else result += curr;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.romanToInt("III"));     // 3
        System.out.println(sol.romanToInt("LVIII"));   // 58
        System.out.println(sol.romanToInt("MCMXCIV")); // 1994
    }
}
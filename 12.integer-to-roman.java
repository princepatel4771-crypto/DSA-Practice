class Solution {
    public String intToRoman(int num) {
        
        // Values aur Roman symbols
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        
        StringBuilder result = new StringBuilder();
        
        // Har value ke liye check karo
        for(int i = 0; i < values.length; i++) {
            
            // Jab tak num >= value tab tak symbol add karo
            while(num >= values[i]) {
                result.append(symbols[i]); // symbol add karo
                num -= values[i];          // num se value hatao
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.intToRoman(3));    // III
        System.out.println(sol.intToRoman(58));   // LVIII
        System.out.println(sol.intToRoman(1994)); // MCMXCIV
    }
}
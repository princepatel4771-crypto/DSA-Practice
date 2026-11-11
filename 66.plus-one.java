class Solution {
    public int[] plusOne(int[] digits) {
        
        // Peeche se shuru karo
        for(int i = digits.length - 1; i >= 0; i--) {
            
            // 9 nahi hai, bas 1 badhao aur return karo
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            
            // 9 hai, to 0 karo aur carry aage bhejo
            digits[i] = 0;
        }
        
        // Sab 9 the (jaise 999), to naya array banao: 1000
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(java.util.Arrays.toString(
            sol.plusOne(new int[]{1,2,3})));   // [1, 2, 4]
        System.out.println(java.util.Arrays.toString(
            sol.plusOne(new int[]{4,3,2,1}))); // [4, 3, 2, 2]
        System.out.println(java.util.Arrays.toString(
            sol.plusOne(new int[]{9,9,9})));   // [1, 0, 0, 0]
    }
}
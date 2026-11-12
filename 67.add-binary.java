class Solution {
    public String addBinary(String a, String b) {
        
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        
        // Dono strings ke peeche se ek-ek digit jodo
        while(i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            
            if(i >= 0) sum += a.charAt(i--) - '0';
            if(j >= 0) sum += b.charAt(j--) - '0';
            
            // Current bit = sum % 2, carry = sum / 2
            sb.append(sum % 2);
            carry = sum / 2;
        }
        
        // Peeche se bana hai, to ulta karke return karo
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.addBinary("11", "1"));     // 100
        System.out.println(sol.addBinary("1010", "1011")); // 10101
    }
}
class Solution {
    public String multiply(String num1, String num2) {
        
        int n = num1.length(), m = num2.length();
        int[] result = new int[n + m];
        
        // Right se left multiply karo
        for(int i = n - 1; i >= 0; i--) {
            for(int j = m - 1; j >= 0; j--) {
                
                int mul = (num1.charAt(i) - '0') * 
                          (num2.charAt(j) - '0');
                
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = mul + result[p2];
                
                result[p2] = sum % 10;
                result[p1] += sum / 10;
            }
        }
        
        // Result banao
        StringBuilder sb = new StringBuilder();
        for(int digit : result) {
            if(!(sb.length() == 0 && digit == 0)) {
                sb.append(digit);
            }
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.multiply("2", "3"));     // 6
        System.out.println(sol.multiply("123", "456")); // 56088
    }
}
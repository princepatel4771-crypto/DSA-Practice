class Solution {
    public int reverse(int x) {
        long result = 0;                    // reversed number yahan banega (long isliye taaki overflow pakad sakein)

        while (x != 0) {                    // jab tak digits bache hain
            int digit = x % 10;              // last digit nikala (Java mein negative % bhi sahi sign deta hai)
            x /= 10;                         // us digit ko x se hata diya
            result = result * 10 + digit;    // result ko shift karke naya digit joda
        }

        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {  // 32-bit range check
            return 0;                        // overflow ho to 0 return
        }

        return (int) result;                 // final reversed number, int mein convert
    }
}
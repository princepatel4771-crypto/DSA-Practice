class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        // nums.length - 1 tak chalayenge kyunki last index par pahunchne ke baad jump nahi lena
        for (int i = 0; i < nums.length - 1; i++) {
            // Is index se maximum kitna aage ja sakte hain
            farthest = Math.max(farthest, i + nums[i]);

            // Jab current jump ki boundary reach ho jaye
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
                
                // Early exit agar already last index reach ya cross ho gaya
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }
}
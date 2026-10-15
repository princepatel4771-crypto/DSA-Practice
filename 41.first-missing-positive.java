import java.util.Arrays;

public class Solution {
    // LeetCode core logic: O(n) time, O(1) space
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // Har number ko uske correct index (value - 1) par swap karo
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int correctIdx = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[correctIdx];
                nums[correctIdx] = temp;
            }
        }

        // Pehla index dhoondo jahan nums[i] != i + 1 ho
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // Agar 1 se n tak sab sahi jagah hain, toh missing n + 1 hoga
        return n + 1;
    }

    // VS Code mein run karne ke liye main method
    public static void main(String[] args) {
        int[] test1 = {1, 2, 0};
        int[] test2 = {3, 4, -1, 1};
        int[] test3 = {7, 8, 9, 11, 12};

        System.out.println("Input: [1, 2, 0]         -> Output: " + firstMissingPositive(test1)); // 3
        System.out.println("Input: [3, 4, -1, 1]     -> Output: " + firstMissingPositive(test2)); // 2
        System.out.println("Input: [7, 8, 9, 11, 12] -> Output: " + firstMissingPositive(test3)); // 1
    }
}
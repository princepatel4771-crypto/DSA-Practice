import java.util.Arrays;

public class MedianTwoArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        
        for(int i = 0; i < nums1.length; i++)
            merged[i] = nums1[i];
        for(int i = 0; i < nums2.length; i++)
            merged[nums1.length + i] = nums2[i];
        
        Arrays.sort(merged);
        
        int n = merged.length;
        if(n % 2 == 0)
            return (merged[n/2 - 1] + merged[n/2]) / 2.0;
        else
            return merged[n/2];
    }

    public static void main(String[] args) {
        MedianTwoArrays sol = new MedianTwoArrays();
        System.out.println(sol.findMedianSortedArrays(
            new int[]{1,3}, new int[]{2}));     // 2.0
        System.out.println(sol.findMedianSortedArrays(
            new int[]{1,2}, new int[]{3,4}));   // 2.5
    }
}
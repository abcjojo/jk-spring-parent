package 面试题.leetcode;

public class LC88 {

    public static void main(String[] args) {

    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        int len = nums1.length;

        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (nums1[j] > nums1[j+1]) {
                    int it = nums1[j];
                    nums1[j] = nums1[j+1];
                    nums1[j+1] = it;
                }
            }
        }

    }


}

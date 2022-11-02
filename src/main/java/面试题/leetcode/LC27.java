package 面试题.leetcode;

public class LC27 {
    public static void main(String[] args) {
        new LC27().removeElement(new int[]{3,2,2,3}, 3);
    }

    public int removeElement(int[] nums, int val) {
        int p = nums.length-1;
        for (int i = nums.length-1; i >= 0; i--) {
            if (val == nums[i]) {
                if (i < p) {
                    nums[i] = nums[p];
                    nums[p] = val;
                }
                p--;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        return p + 1;
    }
}

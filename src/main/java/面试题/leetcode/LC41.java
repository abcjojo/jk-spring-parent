package 面试题.leetcode;

import java.util.Arrays;

public class LC41 {
    public static void main(String[] args) {

    }

    public int firstMissingPositive(int[] nums) {

        Arrays.sort(nums);
        if (nums[nums.length - 1] <= 0) {
            return 1;
        }
        int rst = 1;

        for (int i = 0; i < nums.length; ) {
            while (i<nums.length && nums[i] <= 0) {
                i++;
            }
            int it = nums[i];
            while (i < nums.length-1 && nums[i+1] == it) {
                i++;
            }
            if (rst<nums[i]) {
                return rst;
            } else {
                rst++;
            }
        }

        return rst;
    }
}

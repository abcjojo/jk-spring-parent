package 面试题.leetcode;

import java.util.Arrays;

public class LC16 {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{4,0,5,-5,3,3,0,-4,-5}, -2));
    }

    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                res = Math.abs((res - target)) > Math.abs(sum - target) ? sum : res;

                if (sum < target) {
                    l++;
                } else if (sum == target) {
                    return sum;
                } else {
                    r--;
                }
            }
        }
        return res;
    }
}

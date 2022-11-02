package 面试题.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15 {

    public static void main(String[] args) {

        System.out.println(threeSum(new int[]{-1,2,1,-4}));// -4, -1,-1,0,1,2
    }

    public  static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {
            if (nums[i] > 0) return res;
            if (i > 0 && nums[i] == nums[i-1]) continue;

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[i] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    int ln = nums[left];
                    int rn = nums[right];
                    while (ln == nums[left] && left < right) left++;
                    while (rn == nums[right] && left < right) right--;
//                    left++;
//                    right--;
                }
            }
        }
        return res;
    }
}

package 面试题.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC18 {

    public static void main(String[] args) {

        System.out.println(fourSum(new int[]{2, 2, 2, 2, 2}, 8));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4)
            return res;
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 3; k++) {
            if (k > 0 && nums[k] == nums[k-1]) {
                continue;
            }
            int len = nums.length;
            int minV = nums[k] + nums[k+1] + nums[k+2] + nums[k+3];
            if (minV > target) {
                break;
            }
            int maxV = nums[k] + nums[len - 1] + nums[len - 2] + nums[len - 3];
            if (target > maxV) {
                break;
            }

            for (int i = k + 1; i < len - 2; i++) {
                if (i > 1 && nums[i] == nums[i-1])
                    continue;
                int l = i + 1;
                int r = len - 1;
                int min = nums[k] + nums[i] + nums[l+1] + nums[l];
                if (target < min) {
                    continue;
                }
                int max = nums[k] + nums[i] + nums[r-1] + nums[r];
                if (target > max) {
                    continue;
                }

                while (l < r) {
                    int val = nums[k] + nums[i] + nums[l] + nums[r];
                    if (val == target) {
                        res.add(Arrays.asList(nums[k], nums[i], nums[l], nums[r]));
                        l++;
                        while (l < r && nums[l] == nums[l-1]) {
                            l++;
                        }
                        r--;
                        while (l < r && nums[r] == nums[r -1]) {
                            r--;
                        }
                    } else if (val > target)
                        r--;
                    else
                        l++;
                }
            }
        }
        return res;
    }
}

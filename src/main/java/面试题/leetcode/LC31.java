package 面试题.leetcode;

public class LC31 {

    public static void main(String[] args) {
        LC31 lc31 = new LC31();
        lc31.nextPermutation(new int[]{1,3,2});
    }

    public void nextPermutation(int[] nums) {
        boolean flag = true;
        int idx = -1;
        for (int i = (nums.length - 1); i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                idx = i - 1;
                flag = false;
                break;
            }
        }
        if (flag) {
            revert(nums, 0, nums.length - 1);
            return;
        }

        for (int i = (nums.length - 1); i > idx; i--) {
            if (nums[i] > nums[idx]) {
                int it = nums[i];
                nums[i] = nums[idx];
                nums[idx] = it;
                break;
            }
        }
        revert(nums, idx +1, nums.length - 1);
    }

    private void revert(int[] nums, int l, int r) {
        while (l < r) {
            int it = nums[l];
            nums[l] = nums[r];
            nums[r] = it;
            l++;
            r--;
        }
    }


}

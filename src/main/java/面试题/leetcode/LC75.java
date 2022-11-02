package 面试题.leetcode;

public class LC75 {

    public static void main(String[] args) {
        new LC75().sortColors(new int[]{2,0,2,1,1,0});
    }

    public void sortColors(int[] nums) {
//        Arrays.sort(nums);

        int len = nums.length;

        if (len == 1) {
            return;
        }

        for (int j = 0; j < len - 1; j++) {
            for (int i = 0; i < len - 1 - j; i++) {
                if (nums[i] > nums[i+1]) {
                    int it = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = it;
                }
            }
        }


    }
}

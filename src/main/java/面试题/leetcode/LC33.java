package 面试题.leetcode;

public class LC33 {

    public static void main(String[] args) {
        LC33 lc33 = new LC33();
        System.out.println(lc33.search(new int[]{4,5,6,7,0,1,2}, 0));
    }

    public int search(int[] nums, int target) {
        int len = nums.length;
        int base = nums[0];
        if (target >= base) {
            for (int i = 0; i < len; i++) {
                if (target == nums[i]) {
                    return i;
                }
                if (i <len - 1 && nums[i+1] < nums[i]) {
                    return -1;
                }
            }
        } else {
            for (int i = (len - 1); i >= 0; i--) {
                if (nums[i] == target) {
                    return i;
                }
                if (i > 0 && nums[i-1] > nums[len-1]) {
                    return -1;
                }
            }
        }

        return -1;
    }
}

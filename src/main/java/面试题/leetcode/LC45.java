package 面试题.leetcode;

public class LC45 {

    public static void main(String[] args) {
        System.out.println(new LC45().jump(new int[]{2,3,1,1,4}));
    }

    public int jump(int[] nums) {
        int step = 0;
        int pos = nums.length - 1;

        while (pos > 0) {
            for (int i = 0; i < pos; i++) {
                if (nums[i] >= pos - i) {
                    pos = i;
                    step++;
                    break;
                }
            }
        }
        return step;
    }
}

package 面试题.leetcode;

public class LC26 {

    public static void main(String[] args) {
        System.out.println(new LC26().removeDuplicates(new int[]{1,1,2}));
    }

    public int removeDuplicates(int[] nums) {
        int[] st = new int[nums.length];
        int len = 0;
        for (int i = 0; i < nums.length; ) {
            int it = nums[i];
            st[len] = it;
            len++;
            i++;
            while (i < nums.length && nums[i] == it) {
                i++;
            }
        }

        for (int i = 0; i < len; i++) {
            nums[i] = st[i];
        }
        return len;
    }
}

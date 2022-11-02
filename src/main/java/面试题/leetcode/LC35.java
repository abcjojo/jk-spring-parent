package 面试题.leetcode;

public class LC35 {

    public static void main(String[] args) {
        int i = new LC35().searchInsert(new int[]{1, 3, 5, 6}, 2);
        System.out.println(i);
    }
    public int searchInsert(int[] nums, int target) {

        if (nums.length == 0 || target < nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }

        int a = -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}

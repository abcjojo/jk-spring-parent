package 面试题.leetcode;

public class LC34 {

    public static void main(String[] args) {
        int[] ints = new LC34().searchRange(new int[]{1}, 1);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int[] rst = new int[2];
        int start = -1;
        int end = -1;
        int idx = search(nums, target);
        if (idx != -1) {
            start = idx;
            while (start >=0 && nums[start] == nums[idx]) {
                start--;
            }
            end = idx;
            while (end < nums.length && nums[end] == nums[idx]) {
                end++;
            }
            start++;
            end--;
        }
        rst[0] = start;
        rst[1] = end;

        return rst;
    }


    public int search(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int rst = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (left < right && target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return rst;
    }

}

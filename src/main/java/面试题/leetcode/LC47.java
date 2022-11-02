package 面试题.leetcode;

import java.util.*;

public class LC47 {

    public static void main(String[] args) {
        new LC47().permuteUnique(new int[]{1,1,2});
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return rst;
        }

        Arrays.sort(nums);

        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[len];


        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, 1, len, used, path, rst);
            used[i] = false;
            path.removeLast();
        }

        return rst;
    }

    private void dfs(int[] nums, int depat, int len, boolean[] used, Deque<Integer> path, List<List<Integer>> rst) {
        if (len == depat) {
            rst.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, depat + 1, len, used, path, rst);
            used[i] = false;
            path.removeLast();
        }
    }


}

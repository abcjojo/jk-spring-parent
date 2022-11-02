package 面试题.leetcode;

import java.util.*;

public class LC46 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return rst;
        }
        boolean used[] = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, len, 0, path, used, rst);
        return rst;
    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> rst) {
        if (len == depth) {
            rst.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, path, used, rst);
            used[i] = false;
            path.removeLast();
        }
    }
}

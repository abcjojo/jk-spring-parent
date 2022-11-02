package 面试题.leetcode;

import java.util.*;

public class LC40 {
    public static void main(String[] args) {

    }

    List<List<Integer>> rst = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, target);
        return rst;
    }

    public void dfs(int[] arr, int start, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            rst.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (arr[i] > target)
                break;
            list.add(arr[i]);
            dfs(arr, i+1, target - arr[i]);
            list.remove(list.size() - 1);
            while (i < arr.length - 1 && arr[i] == arr[i+1])
                ++i;
        }
    }
}

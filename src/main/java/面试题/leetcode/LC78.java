package 面试题.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC78 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        rst.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> tmp = new ArrayList<>();
            for (List<Integer> list : rst) {
                List<Integer> it = new ArrayList<>(list);
                it.add(num);
                tmp.add(it);
            }
            rst.addAll(tmp);
        }
        return rst;
    }
}

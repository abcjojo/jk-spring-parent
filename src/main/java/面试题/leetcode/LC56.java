package 面试题.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC56 {

    public static void main(String[] args) {
        new LC56().merge(new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        });
    }

    public int[][] merge(int[][] a) {
        List<int[]> rst = new ArrayList<>();
        Arrays.sort(a, (x,y) -> x[0] - y[0]);

        int l = a[0][0];
        int r = a[0][1];

        for (int i =1; i < a.length; i++) {
            if (a[i][0] > r) {
                rst.add(new int[]{l, r});
                l = a[i][0];
                r = a[i][1];
            } else {
                r = Math.max(r, a[i][1]);
            }
        }
        rst.add(new int[]{l, r});
        return rst.toArray(new int[0][]);
    }
}

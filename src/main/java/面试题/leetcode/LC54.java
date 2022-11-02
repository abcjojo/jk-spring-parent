package 面试题.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC54 {

    public static void main(String[] args) {
        new LC54().spiralOrder(new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        });
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> rst = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        if (matrix == null || m == 0 || n == 0) {
            return rst;
        }

        int l = 0;
        int r = matrix[0].length - 1;
        int u = 0;
        int d = matrix.length - 1;

        while (l <= r && u <= d) {
            for (int i = l; i <= r; i++) {
                rst.add(matrix[u][i]);
            }
            u++;
            for (int i = u; i <= d; i++) {
                rst.add(matrix[i][r]);
            }
            r--;
            for (int i = r; i >= l && u <= d; i--) {
                rst.add(matrix[d][i]);
            }
            d--;
            for (int i = d; i >= u && l <= r; i--) {
                rst.add(matrix[i][l]);
            }
            l++;
        }
        return rst;
    }

}

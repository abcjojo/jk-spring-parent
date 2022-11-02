package 面试题.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC48 {
    public static void main(String[] args) {
        new LC48().rotate(new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        });
    }

    public void rotate(int[][] matrix) {
        int len = matrix.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int j = (len - 1); j >= 0; j--) {
//                System.out.print(matrix[i][j] + " ");
                int it = matrix[j][i];
                list.add(it);
            }
        }
        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            int y = i % len;
            int x = i / len;
            matrix[x][y] = list.get(i);
        }

    }
}

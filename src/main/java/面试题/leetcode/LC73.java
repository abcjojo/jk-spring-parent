package 面试题.leetcode;

import java.util.HashSet;

public class LC73 {

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,9,8},
                {33,34,21}
        };
        System.out.println(a[3][2]);
    }

    public void setZeroes(int[][] matrix) {
        int len1 = matrix.length;
        int len2 = matrix[0].length;
        if (len1 == 0 || len2 == 0) {
            return;
        }

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (matrix[i][j] == 0) {
                    set1.add(i);
                    set2.add(j);
                }
            }
        }

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (set1.contains(i) || set2.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }

    }
}

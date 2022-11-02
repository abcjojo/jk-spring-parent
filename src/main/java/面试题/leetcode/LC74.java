package 面试题.leetcode;

public class LC74 {

    public static void main(String[] args) {

    }

    public boolean searchMatrix(int[][] matrix, int target) {

        int len1 = matrix.length;
        int len2 = matrix[0].length;

        if (len1 == 0 || len2 == 0) {
            return false;
        }

        if (target > matrix[len1-1][len2-1] || target < matrix[0][0]) {
            return false;
        }

        int row = -1;
        for (int i = 1; i < matrix.length; i++) {
            if (target < matrix[i][0]) {
                row = i - 1;
                break;
            }
        }

        if (row == -1) {
            row = len1 - 1;
        }

        for (int i = 0; i < len2; i++) {
            if (matrix[row][i] == target) {
                return true;
            }
            if (matrix[row][i] > target) {
                return false;
            }
        }
        return false;
    }
}

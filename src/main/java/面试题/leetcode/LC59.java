package 面试题.leetcode;

public class LC59 {

    public static void main(String[] args) {
        new LC59().generateMatrix(3);
    }

    public int[][] generateMatrix(int n) {
        int[][] a = new int[n][n];

        if (n == 1) {
            a[0][0] = 1;
            return a;
        }

        int l = 0;
        int r = n - 1;
        int u = 0;
        int d = n - 1;

        int t = 1;

        while (t <= n * n) {
            for (int i = l; i <= r; i++) {
                a[u][i] = t++;
            }
            u++;
            for (int i = u; i <= d; i++) {
                a[i][r] = t++;
            }
            r--;
            for (int i = r; i >= l; i--) {
                a[d][i] = t++;
            }
            d--;
            for (int i = d; i >= u; i--) {
                a[i][l] = t++;
            }
            l++;
        }

        return a;

    }
}

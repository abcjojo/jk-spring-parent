package 面试题.hwexam;

import java.util.*;

public class Q1 {

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int row = in.nextInt();
        int lie = in.nextInt();
        int[][] a = new int[row][lie];
        Map<Integer, Integer> map = new HashMap<>();
        for (int k = 0; k < row; k++) {
            for (int l = 0; l < lie; l++) {
                int it = in.nextInt();
                a[k][l] = it;
                map.merge(it, 1, Integer::sum);
            }
        }

        List<List<Integer>> rst = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < lie; j++) {
                if (map.get(a[i][j]) ==  1) {
                    list.add(-1);
                } else {
                    list.add(find(a, i, j, a[i][j], row, lie));
                }
            }
            rst.add(list);
        }

        System.out.println(rst);
    }

    private static int find(int[][] a, int i, int j, int target, int row, int lie) {
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < row; k++) {
            for (int l = 0; l < lie; l++) {
                if (target == a[k][l]) {
                    int x = Math.abs(i - k);
                    int y = Math.abs(j - l);
                    int sum = x + y;
                    if (sum != 0) {
                        min = Math.min(min, sum);
                    }
                }
            }
        }

        return min;
    }
}

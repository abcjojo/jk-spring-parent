package 面试题.huawei;

import java.util.Scanner;

public class HM1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            if (n == 0) {
                return;
            }
            helper(n);
        }
    }

    public static void helper(int n) {

        int dr = 0;
        while (n >= 3) {
            int m = n % 3;
            dr += n/3;
            n = n/3 + m;
        }
        if (n == 2) {
            dr += 1;
        }
        System.out.println(dr);
    }
}

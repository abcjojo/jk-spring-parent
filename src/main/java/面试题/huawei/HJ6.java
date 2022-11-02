package 面试题.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        long m = (long) Math.sqrt(num);
        System.out.println("  sqrt： " + m);

        for (long i = 2; i <= m; i++) {
            while (num % i == 0) {
                num /= i;
                System.out.print(i + " ");
            }
        }

        System.out.println(num == 1 ? "" : num + " ");
    }
}

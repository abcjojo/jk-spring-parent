package 面试题.huawei;

import java.util.Scanner;

public class HJ7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num = sc.nextDouble();
        int res = num - (int)num >= 0.5 ? (int)(num + 0.5) : (int)num;
        System.out.println(res);
    }
}

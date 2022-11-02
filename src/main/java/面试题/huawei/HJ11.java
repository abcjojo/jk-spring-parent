package 面试题.huawei;

import java.util.Scanner;

public class HJ11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder builder = new StringBuilder(s);
        System.out.println(builder.reverse());
    }
}

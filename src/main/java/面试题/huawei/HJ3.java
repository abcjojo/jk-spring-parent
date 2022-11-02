package 面试题.huawei;

import java.util.Scanner;
import java.util.TreeSet;

public class HJ3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < num; i++) {
            set.add(sc.nextInt());
        }

        for (Integer i : set) {
            System.out.println(i);
        }
    }
}

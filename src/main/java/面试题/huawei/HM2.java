package 面试题.huawei;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class HM2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TreeSet<Integer> set = new TreeSet<>();
        int i = in.nextInt();
        for (int k = 0; k < i; k++) {
            int n = in.nextInt();
            set.add(n);
        }
        for (Integer it : set) {
            System.out.println(it);
        }
    }
}

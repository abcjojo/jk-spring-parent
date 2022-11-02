package 面试题.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class HJ9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        TreeSet<Character> set = new TreeSet<>();
        char[] arr = str.toCharArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            boolean add = set.add(arr[i]);
            if (add) {
                System.out.print(arr[i]);
            }
        }
    }
}

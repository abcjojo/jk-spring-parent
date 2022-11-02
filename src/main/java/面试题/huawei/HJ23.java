package 面试题.huawei;

import java.util.Scanner;

public class HJ23 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int[] arr = new int[26];

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            arr[c - 'a']++;
        }

        int min = 20;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min && arr[i] != 0) {
                min = arr[i];
            }
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (arr[c - 'a'] != min) {
                System.out.print(c);
            }
        }

    }

    public static void func() {}
}

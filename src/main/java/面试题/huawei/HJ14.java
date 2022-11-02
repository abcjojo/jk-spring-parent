package 面试题.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class HJ14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.next();
        }
        Arrays.sort(array);
        for (String str : array) {
            System.out.println(str);
        }
       // Arrays.stream(arr).sorted().forEach(System.out::println);
    }
}

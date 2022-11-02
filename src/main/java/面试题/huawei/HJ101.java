package 面试题.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class HJ101 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer arr [] = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int flag = in.nextInt();

        if (flag == 0) {
            Arrays.sort(arr);
        } else {
            Arrays.sort(arr, (a, b) -> b-a);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

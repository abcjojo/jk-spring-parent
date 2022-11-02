package 面试题.huawei;

import java.util.ArrayList;
import java.util.Scanner;

public class HJ33 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        long num = in.nextLong();

        toLong(str);
        toStr(num);
    }

    private static void toStr(long num) {
        String res = "";
        for (int i = 0; i < 4; i++) {
            res = num % 256 + "." + res;
            num /= 256;
        }
        System.out.println(res.substring(0,res.length() - 1));
    }

    private static void toLong(String str) {
        String[] arr = str.split("\\.");
        long n = 0l;
        for (int i = 0; i < 4; i++) {
            n = n * 256 + Long.parseLong(arr[i]);
        }
        System.out.println("" + n);
    }
}

package 面试题.huawei;

import net.sf.jsqlparser.statement.select.First;

import javax.naming.RefAddr;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class HJ20 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        String str = "";

        String ok = "OK";
        String err = "NG";

        while (in.hasNextLine()) {
            str = in.nextLine();
            if (str.length() <= 8) {
                System.out.println(err);
            } else if (!check1(str)) {
                System.out.println(err);
            } else if (!check2(str)) {
                System.out.println(err);
            } else {
                System.out.println(ok);
            }
        }
    }

    private static boolean check1(String str) {
        int[] arr = new int[4];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c > 64 && c <91) {
                arr[0] = 1;
            } else if (c > 96 && c < 123) {
                arr[1] = 1;
            } else if (c > 47 && c < 58) {
                arr[3] = 1;
            } else {
                arr[2] = 1;
            }
        }

        int times = 0;
        for (int i = 0; i < arr.length; i++) {
            times += arr[i];
        }
        return times > 2;
    }

    private static boolean check2(String str) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < str.length() - 3; i++) {
            String s = str.substring(i, i+3);
            if (set.contains(s)) {
                return false;
            }else {
                set.add(s);
            }
        }
        return true;
    }


}

package 面试题.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ17 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String regex = "(A|D|W|S)[0-9]{1,2}";
        List<String> list = new ArrayList<>();
        String[] arr = s.split(";");
        for (String str : arr) {
            if (str.matches(regex)) {
                list.add(str);
            }
        }
        int X = 0;
        int Y = 0;
        for (String str : list) {
            String pos = str.substring(0, 1);
            int num = Integer.valueOf(str.substring(1));
            if ("A".equals(pos)) {
                X = X - num;
            }
            if ("D".equals(pos)) {
                X = X + num;
            }
            if ("W".equals(pos)) {
                Y = Y + num;
            }
            if ("S".equals(pos)) {
                Y = Y - num;
            }
        }
        System.out.println(X + "," + Y);
    }
}

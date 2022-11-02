package 面试题.huawei;

import java.util.Scanner;
import java.util.TreeSet;

public class HJ4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while (sc.hasNext()) {
            String in = sc.nextLine();
            while (in.length() > 8) {
                System.out.println(in.substring(0,8));
                in = in.substring(8);
            }
            in = in + "00000000";
            System.out.println(in.substring(0,8));
        }
    }
}

package 面试题.huawei;

import java.util.Scanner;

public class HJ65 {

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        if (s1.length() > s2.length()) {
            String tmp = s1;
            s1 = s2;
            s2 = tmp;
        }

        String maxSub = "";
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                String sub = s1.substring(i, j+1);
                if (!s2.contains(sub)) {
                    break;
                } else {
                    if (sub.length() > maxSub.length()) {
                        maxSub = sub;
                    }
                }
            }
        }

        System.out.println(maxSub);
    }
}

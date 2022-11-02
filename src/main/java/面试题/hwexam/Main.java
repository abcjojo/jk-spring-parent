package 面试题.hwexam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        String line = in.nextLine();
        String line2 = in.nextLine();

        String[] s1 = line.split(" ");
        String[] s2 = line2.split(" ");

        if (s2.length > s1.length) {
            System.out.println(false);
            return;
        }

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        for (int i = 0; i < s1.length; i++) {
            char[] ch1 = s1[i].toCharArray();
            Arrays.sort(ch1);
            list1.add(new String(ch1));
        }

        for (int i = 0; i < s2.length; i++) {
            char[] ch2 = s2[i].toCharArray();
            Arrays.sort(ch2);
            list2.add(new String(ch2));
        }

        for (String s : list2) {
            if (!list1.contains(s)) {
                System.out.println(false);
                return;
            }
        }

        System.out.println(true);
    }
}

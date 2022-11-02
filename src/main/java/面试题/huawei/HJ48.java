package 面试题.huawei;

import java.util.ArrayList;
import java.util.Scanner;

public class HJ48 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(in.nextInt());
        for (int i = 0; i < num - 1; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            if (!list.contains(m)) {
                list.add(m);
            }
            list.add(list.indexOf(m), n);
        }

        int del = in.nextInt();
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) != del) {
                System.out.print(list.get(i) + " ");
            }
        }

    }
}

package 面试题.hwexam;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        in.close();

        int c = 0;
        while (true) {
            int t1 = s + a * c;
            int t2 = s - a * c;

            int f1 = Math.abs(t1 - t) % b;
            if (f1 == 0) {
                System.out.println(c);
                return;
            }

            int f2 = Math.abs(t2 - t) % b;
            if (f2 == 0) {
                System.out.println(c);
                return;
            }

            c++;

            if (c > 10<<5) {
                return;
            }
        }



    }
}

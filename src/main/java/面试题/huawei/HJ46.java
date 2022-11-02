package 面试题.huawei;

import java.util.Scanner;

public class HJ46 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        int len = in.nextInt();

        System.out.println(line.substring(0,len));
    }
}

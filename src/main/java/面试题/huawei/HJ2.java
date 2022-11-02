package 面试题.huawei;

import java.util.Scanner;

public class HJ2 {

    /**
     * 描述
     * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
     *
     * 数据范围： 1 \le n \le 1000 \1≤n≤1000
     * 输入描述：
     * 第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字符。
     *
     * 输出描述：
     * 输出输入字符串中含有该字符的个数。（不区分大小写字母）
     *
     * 示例1
     * 输入：
     * ABCabc
     * A
     * 复制
     * 输出：
     * 2
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String target = sc.nextLine();

        char[] arr = input.toCharArray();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            String s = String.valueOf(arr[i]);
            if (target.equalsIgnoreCase(s)) {
                count++;
            }
        }
        System.out.println(count);

    }
}

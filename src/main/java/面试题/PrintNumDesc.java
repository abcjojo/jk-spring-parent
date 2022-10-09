package 面试题;

import org.checkerframework.checker.units.qual.A;

import java.util.Scanner;

/**
 *  倒序输出 数字 并相加
 */
public class PrintNumDesc {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        reversal(num);
        reversalAndAdd(num);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE + 1);
        System.out.println(Integer.MAX_VALUE + 2);
    }

    // 反转后并相加
    public static void reversalAndAdd(int num) {
        StringBuilder builder = new StringBuilder();
        int oldNum = num;
        while (num > 0) {
            builder = builder.append(num % 10);
            num /= 10;
        }
        int rev = Integer.parseInt(builder.toString());
        System.out.println(oldNum + "  " + rev);
        System.out.println(oldNum + rev);
    }

    // 反转数字输出
    public static void reversal(int num) {
        System.out.print(num + "反转后：");
        while (num > 0) {
            int tmp = num % 10;
            System.out.print(tmp);
            num /= 10;
        }
        System.out.println();
    }
}

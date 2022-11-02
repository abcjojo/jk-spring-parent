package 面试题.huawei;

import java.util.Scanner;

/**
 *  题目描述：
 *   给定一个字符串s，最多只能进行一次变换，返回变换后能得到的最小字符串（按照字典序进行比较）。
 *   变换规则：交换字符串中任意两个不同位置的字符。
 *   输入描述：
 *   一串小写字母组成的字符串s。
 *   输出描述：
 *   按照要求进行变换得到的最小字符串。
 *   备注：
 *   s是都是小写字符组成
 *   1<=s.length<=1000
 *   示例
 *   输入：abcdefM
 *   输出：abcdef
 *   说明：abcdef已经是最小字符串，不需要交换
 *
 *   输入：bcdefa
 *   输出：acdefb
 *   说明：a和b进行位置交换，可以得到最小字符串
 *
 * 原文链接：https://blog.csdn.net/m0_46084322/article/details/125590148
 */
public class M67 {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        char[] arr = input.toCharArray();

        // 最小值和第一个字符交换位置 得到最小字典序字符串
        for (int i = 0; i < arr.length; i++) {

            // 最小值和下标
            char minVal = arr[i];
            int minIndex = i;

            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < minVal) {
                    minIndex = j;
                    minVal = arr[j];
                }
            }

            if (minIndex != i && arr[i] != minVal) {
                arr[minIndex] = arr[i];
                arr[i] = minVal;
                System.out.println(new String(arr));
                return;
            }
        }
        System.out.println(input);

    }
}

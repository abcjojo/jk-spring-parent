package 面试题.huawei;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *   定义当一个字符串只有元音字母(a,e,i,o,u,A,E,I,O,U)组成,
 *   称为元音字符串，现给定一个字符串，请找出其中最长的元音字符串，
 *   并返回其长度，如果找不到请返回0，
 *   字符串中任意一个连续字符组成的子序列称为该字符串的子串
 *   <p>
 *   输入描述：
 *   一个字符串其长度 0<length ,字符串仅由字符a-z或A-Z组成
 *   输出描述：
 *   一个整数，表示最长的元音字符子串的长度
 *   <p>
 *   示例1：
 *   输入
 *   asdbuiodevauufgh
 *   输出
 *   3
 *   说明：
 *   最长的元音字符子串为uio和auu长度都为3，因此输出3
 */
public class M66 {

    public static void main(String[] args) {
        test();
    }

    public static void test () {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();

        ArrayList<Character> list = new ArrayList<>();
        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');
        list.add('A');
        list.add('E');
        list.add('I');
        list.add('O');
        list.add('U');

        int maxLen = 0;
        int tempLen = 0;

        for (int i = 0; i < chars.length; i++) {

            while (i < chars.length && list.contains(chars[i])) {
                i++;
                tempLen++;
            }

            maxLen = Math.max(tempLen, maxLen);
            tempLen = 0;

        }
        System.out.println(maxLen);

    }
}

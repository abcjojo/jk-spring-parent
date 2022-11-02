package 面试题.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        HJ5 hj5 = new HJ5();
        hj5.test1(line);
        hj5.test2(line);
    }

    // 解法1
    public void test1(String line) {
        line = line.substring(2);
        System.out.println(Integer.parseInt(line, 16));
    }

    private static final  int BASE = 16;
    private static Map<Character, Integer> map = new HashMap<Character, Integer>(){{
        put('0', 0);
        put('1', 1);
        put('2', 2);
        put('3', 3);
        put('4', 4);
        put('5', 5);
        put('6', 6);
        put('7', 7);
        put('8', 8);
        put('9', 9);
        put('A', 10);
        put('B', 11);
        put('C', 12);
        put('D', 13);
        put('E', 14);
        put('F', 15);
        put('a', 10);
        put('b', 11);
        put('c', 12);
        put('d', 13);
        put('e', 14);
        put('f', 15);
    }};

    // 解法2
    public void test2(String line) {
        line = line.substring(2);
        int res = 0;
        for (char ch : line.toCharArray()) {
            res = res * BASE + map.get(ch);
        }
        System.out.println(res);
    }
}

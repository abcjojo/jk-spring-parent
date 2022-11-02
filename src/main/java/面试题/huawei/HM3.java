package 面试题.huawei;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class HM3 {
    public static void main(String[] args) throws IOException {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>(){{
            put('1',1);
            put('2',2);
            put('3',3);
            put('4',4);
            put('5',5);
            put('6',6);
            put('7',7);
            put('8',8);
            put('9',9);
            put('A',10);
            put('B',11);
            put('C',12);
            put('D',13);
            put('E',14);
            put('F',15);
        }};
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        s = s.substring(2);
        char[] arr = s.toCharArray();
        int rst = 0;
        for (int i = 0; i < arr.length; i++) {
            rst =  rst * 16 + map.get(arr[i]);
        }
        System.out.println(rst);

    }
}

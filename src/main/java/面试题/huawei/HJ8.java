package 面试题.huawei;

import java.util.Scanner;
import java.util.TreeMap;

public class HJ8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            int v = sc.nextInt();
            if (map.containsKey(k)) {
                map.put(k, map.get(k) + v);
            } else {
                map.put(k, v);
            }
        }
        for (Integer it : map.keySet()) {
            System.out.println(it + " " + map.get(it));
        }
    }
}

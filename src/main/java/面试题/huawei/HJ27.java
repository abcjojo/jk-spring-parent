package 面试题.huawei;

import java.util.*;

public class HJ27 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        String[] arr = new String[num];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.next();
        }
        String tar = in.next();
        int k = in.nextInt();

        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (isBrother(arr[i], tar)) {
                list.add(arr[i]);
            }
        }
        System.out.println(list.size());
        if (k <= list.size()) {
            Collections.sort(list);
            System.out.println(list.get(k-1));
        }
    }

    private static boolean isBrother(String s, String tar) {
        if (s.equals(tar) || s.length() != tar.length()) {
            return false;
        }

        char[] arr1 = s.toCharArray();
        char[] arr2 = tar.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return new String(arr1).equals(new String(arr2));
    }
}

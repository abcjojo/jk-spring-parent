package 面试题.leetcode;

public class LC38 {
    public static void main(String[] args) {
        LC38 lc38 = new LC38();
        System.out.println(lc38.countAndSay(4));
    }

    public String countAndSay(int n) {

        String helper = helper(n, "1");
        return helper;
    }


    public String helper (int n, String str) {
        if (n == 1) {
            return str;
        }
        StringBuilder builder = new StringBuilder();
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; ) {
            int j = i;
            int num = Integer.parseInt(String.valueOf(arr[i]));
            i++;
            while (i < arr.length && arr[j] == arr[i]) {
                i++;
            }
            int count = i - j;
            builder.append(count).append(num);
        }
        return helper(n - 1, builder.toString());
    }
}

package 面试题.leetcode;

public class LC66 {

    public static void main(String[] args) {

    }

    public int[] plusOne(int[] digits) {
        if (digits.length == 0) {
            return digits;
        }

        int idx = -1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] = digits[i] + 1;
                idx = i;
                break;
            }
        }
        if (idx >= 0 && idx != digits.length-1) {
            for (int j = idx+1; j < digits.length; j++) {
                digits[j] = 0;
            }
            return digits;
        }

        if (idx == -1) {
            int[] a = new int[digits.length + 1];
            a[0] = 1;
            for (int i = 1; i < a.length; i++) {
                a[i] = 0;
            }
            return a;
        }

        return digits;

    }
}

package 面试题.leetcode;

public class LC28 {

    public static void main(String[] args) {

    }

    public int strStr(String haystack, String needle) {

        if (haystack.length() < needle.length())
            return -1;
        char[] target = needle.toCharArray();
        char[] chars = haystack.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == target[0]) {
                boolean check = check(chars, i, target);
                if (check) {
                    return i;
                }
            }
        }

        return -1;
    }

    public boolean check(char[] arr, int i, char[] target) {
        if (arr.length - i < target.length)
            return false;

        for (int k = 0; k < target.length; k++) {
            if (arr[i+k] != target[k])
                return false;
        }
        return true;
    }
}

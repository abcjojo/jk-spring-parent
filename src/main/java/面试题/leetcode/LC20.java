package 面试题.leetcode;

public class LC20 {
    public static void main(String[] args) {
        System.out.println(isValid("([])"));
    }

    public static boolean isValid(String s) {
        int l = s.length()/2;
        for (int i = 0; i < l; i++) {
            s = s.replace("()", "").replace("[]", "").replace("{}", "");
        }
        return s.length() == 0;
    }
}

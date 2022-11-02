package 面试题.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC6 {

    public static void main(String[] args) {

    }

    public String convert(String s, int numRows) {
        if (s.length() < 2) return s;
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int i = 0; int flag = -1;
        for (char c : s.toCharArray()) {
            list.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                flag = - flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder builder : list) {
            res.append(builder);
        }
        return res.toString();
    }
}

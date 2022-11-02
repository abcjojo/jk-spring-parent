package 面试题.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC17 {
    public static void main(String[] args) {
        LC17 ins = new LC17();
        ins.letterCombinations("234");
    }

    public List<String> letterCombinations(String digits) {

        if (null == digits || digits.length() == 0) {
            return new ArrayList<>();
        }
        List<StringBuilder> rst = new ArrayList<>();
        String[] str = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<StringBuilder> list1 = new ArrayList<>();
        for (int i = 0; i < digits.toCharArray().length; i++) {
            rst = buildStr(str, digits.charAt(i), rst);
        }
        ArrayList<String> list = new ArrayList<>(rst.size());
        for (int i = 0; i < rst.size(); i++) {
            list.add(rst.get(i).toString());
        }

        System.out.println(list);

        return list;
    }

    public List<StringBuilder> buildStr(String[] arr, char c, List<StringBuilder> rst) {
        String s = arr[c - '0' - 2];
        if (null == rst || rst.size() == 0) {
            for (int i = 0; i < s.toCharArray().length; i++) {
                StringBuilder builder = new StringBuilder();
                rst.add(builder.append(s.charAt(i)));
            }
            return rst;
        } else {
            List<StringBuilder> tmp = new ArrayList<>();
            for (int i = 0; i < s.toCharArray().length; i++) {
                for (int i1 = 0; i1 < rst.size(); i1++) {
                    StringBuilder builder = new StringBuilder();
                    builder.append(rst.get(i1)).append(s.charAt(i));
                    tmp.add(builder);
                }
            }
            return tmp;
        }
    }
}

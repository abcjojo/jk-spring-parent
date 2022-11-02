package 面试题.leetcode;

import java.util.*;

public class LC49 {
    public static void main(String[] args) {
        new LC49().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> rst = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return rst;
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String s = new String(arr);
            List<String> key = map.getOrDefault(s, new ArrayList<String>());
            key.add(str);
            map.put(s, key);
        }
        return new ArrayList<>(map.values());
    }
}

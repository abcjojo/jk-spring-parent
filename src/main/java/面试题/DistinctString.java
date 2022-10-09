package 面试题;

import java.util.HashSet;

/**
 *  0-9组成的8位不重复数字的字符串，产生4个这样的字符串，也是相互不重复
 */
public class DistinctString {

    public static void main(String[] args) {
        HashSet<Integer> intSet = new HashSet<>();
        HashSet<String> strSet = new HashSet<>();

        while (true) {
            intSet.clear();
            while (true) {
                // 产生0-9的随机数
                int a = (int) Math.round(Math.random() * 9);
                intSet.add(a);
                // 如果intSet中有8个数字，转成字符串后添加到strSet中，并跳出此次循环
                if (intSet.size() == 8) {
                    StringBuilder builder = new StringBuilder();
                    intSet.forEach(e -> builder.append(e));
                    System.out.println(builder);
                    strSet.add(builder.toString());
                    break;
                }
            }
            if (strSet.size() == 4) {
                break;
            }
        }

    }
}

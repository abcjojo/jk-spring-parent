package 面试题;

import jdk.nashorn.internal.ir.ReturnNode;
import org.aspectj.weaver.ast.Var;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *  数字金额转中文大写金额
 */
public class NumRevertChinese {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double money = input.nextDouble();
        System.out.println(transformation(money));
    }

    public static StringBuffer transformation (Double money) {
        // 定义数字大写
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "零");
        map.put(1, "壹");
        map.put(2, "贰");
        map.put(3, "叁");
        map.put(4, "肆");
        map.put(5, "伍");
        map.put(6, "陆");
        map.put(7, "柒");
        map.put(8, "捌");
        map.put(9, "玖");
        ArrayList<String> list = new ArrayList<>();
        char[] chars = String.valueOf(money).toCharArray();
        // 记录小数点的位置
        int whichNum = 0;
        for (int i = 0; i < chars.length; i++) {
            if (!String.valueOf(chars[i]).equals(".")) {
                String value = map.get(Integer.valueOf(String.valueOf(chars[i])));
                list.add(value);
            } else {
                whichNum = i + 1;
            }
        }
        return splicing(list, whichNum);
    }

    private static StringBuffer splicing(ArrayList<String> list, int whichNum) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "元");
        map.put(2, "十");
        map.put(3, "百");
        map.put(4, "千");
        map.put(5, "万");
        map.put(6, "十");
        map.put(7, "百");
        map.put(8, "千");
        map.put(9, "亿");
        map.put(10, "十");
        map.put(0, "角");
        map.put(-1, "分");
        map.put(-2, "哩");

        StringBuffer buffer = new StringBuffer();
        for (String s : list) {
            //
            whichNum--;
            if (whichNum < 0) {
                buffer = buffer.append(s).append(map.get(whichNum));
            } else {
                buffer.append(s).append(map.get(whichNum));
            }
        }
        return buffer;
    }
}

/**
 *  输入八位数的数字，转中文大写
 */
class TransChinese {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

    }

    public static StringBuffer transNum() {
        Map<Integer, String> map = new HashMap<>();


        return null;
    }
}

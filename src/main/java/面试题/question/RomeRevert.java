package 面试题.question;

/**
 *  力扣13：罗马数字转整数
 */
public class RomeRevert {

    public static void main(String[] args) {

    }

    public int romanToInt(String s) {
        String str = getRomeStr(s);

        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            res += getIntVal(str.charAt(i));
        }
        return res;
    }

    public String getRomeStr(String str) {
        str = str.replace("IV", "a");
        str = str.replace("IX", "b");
        str = str.replace("XL", "c");
        str = str.replace("XC", "d");
        str = str.replace("CD", "e");
        str = str.replace("CM", "f");
        return str;
    }

    public int getIntVal(char c) {
        switch (c) {
            case 'I' : return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            case 'a': return 4;
            case 'b': return 9;
            case 'c': return 40;
            case 'd': return 90;
            case 'e': return 400;
            case 'f': return 900;
        }

        return 0;
    }


}

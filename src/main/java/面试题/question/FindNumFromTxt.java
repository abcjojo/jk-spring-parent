package 面试题.question;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 读取本地txt， 从中找到数字
 */
public class FindNumFromTxt {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader(""));
        String textLine = "";
        String str = "2";
        while((textLine = bf.readLine()) != null) {
            str += "    " + textLine;
        }
        String[] numbers = str.split("    ");
        double[] num = new double[numbers.length];
        for (int i = 0; i < numbers.length; i++) {

        }

    }
}

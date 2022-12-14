package 面试题.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 *   绘图机器的绘图笔初始位置在原点(0,0)
 *   机器启动后按照以下规则来进行绘制直线
 *   1. 尝试沿着横线坐标正向绘制直线
 *   直到给定的终点E
 *   2. 期间可以通过指令在纵坐标轴方向进行偏移
 *   offsetY为正数表示正向偏移,为负数表示负向偏移
 *
 *   给定的横坐标终点值E 以及若干条绘制指令
 *   请计算绘制的直线和横坐标轴以及x=E的直线组成的图形面积
 *   输入描述:
 *   首行为两个整数N 和 E
 *   表示有N条指令,机器运行的横坐标终点值E
 *   接下来N行 每行两个整数表示一条绘制指令x offsetY
 *   用例保证横坐标x以递增排序的方式出现
 *   且不会出现相同横坐标x
 *   取值范围:
 *   0<N<=10000
 *   0<=x<=E<=20000
 *   -10000<=offsetY<=10000
 *
 *   输出描述:
 *   一个整数表示计算得到的面积 用例保证结果范围在0到4294967295之内
 *   示例1:
 *   输入:
 *   4 10
 *   1 1
 *   2 1
 *   3 1
 *   4 -2
 *   输出:
 *   12
 *
 *   示例2:
 *   输入:
 *   2 4
 *   0 1
 *   2 -2
 *   输出:
 *   4
 */
public class M64 {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        String[] s = in.split(" ");
        int num = Integer.parseInt(s[0]);
        int endX = Integer.parseInt(s[1]);

        List<Integer> listX = new ArrayList<>();
        List<Integer> listY = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            String line = sc.nextLine();
            String[] arr = line.split(" ");
            listX.add(Integer.parseInt(arr[0]));
            listY.add(Integer.parseInt(arr[1]));
        }

        int area = 0;
        int sumY = 0;
        for (int i = 0; i < num; i++) {
            sumY += listY.get(i);
            if (i == num - 1) {
                area += (endX - listX.get(i)) * Math.abs(sumY);
            } else {
                area += (listX.get(i+1) - listX.get(i)) * Math.abs(sumY);
            }
        }

        System.out.println(area);
    }
}

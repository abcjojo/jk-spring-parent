package 面试题.huawei;

import java.util.Arrays;

public class HJ41 {

    public static void main(String[] args) {

    }

    public static int maxArea(int[] height) {

        int maxArea = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            int minH = Math.min(height[l], height[r]);
            int area = (l - r) * minH;
            maxArea = Math.max(maxArea, area);

            while (l < r && height[r] <= minH) {
                r--;
            }
            while (l < r && height[l] <= minH) {
                l++;
            }
        }

        return maxArea;
    }
}

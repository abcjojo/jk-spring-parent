package 面试题.huawei;

import java.util.HashMap;

public class NC61 {
    public static void main(String[] args) {

    }

    /**
     *
     * @param numbers int整型一维数组
     * @param target int整型
     * @return int整型一维数组
     */
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target-numbers[i])+1, i+1};
            }else {
                map.put(numbers[i], i);
            }
        }
        return new int[2];
    }
}

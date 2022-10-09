package 面试题;

import java.time.temporal.Temporal;
import java.util.Arrays;

/**
 *   快排
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4,2,9,6,5,3,7,6,8};
        quickSout(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSout(int[] arr, int left, int right) {

        // 递归结束条件
        if (right < left) {
            return;
        }

        int left0 = left;
        int right0 = right;

        // 比较基数
        int baseNum = arr[left0];

        while (left != right) {

            // 从右开始找比基数小的值
            while (arr[right] >= baseNum && right > left) {
                right--;
            }

            // 从左开始找比基数大的
            while (arr[left] <= baseNum && right > left) {
                left++;
            }

            // 交换两值的位置
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }

        // 基数归位（放在最中间）
        int tem = arr[left0];
        arr[left0] = arr[left];
        arr[left] = tem;

        // 递归调用 将左半部分排好序
        quickSout(arr, left0, left - 1);
        quickSout(arr, left + 1, right0);
    }
}

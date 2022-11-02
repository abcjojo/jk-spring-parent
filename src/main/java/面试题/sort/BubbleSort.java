package 面试题.sort;

import java.util.Arrays;

/**
 *   冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int [] arr = {3,1,5,6,4,9};
        bubbleSort(arr);
    }

    public static  void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j+1] > arr[j]) {
                    arr[j] = arr[j] + arr[j+1];
                    arr[j+1] = arr[j] - arr[j+1];
                    arr[j] = arr[j] - arr[j+1];
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }


}

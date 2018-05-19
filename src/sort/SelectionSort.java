package sort;

/**
 * 选择排序 (不断选择剩余元素的最小值)
 *
 * 首先找到最小的元素，将其余与第一个元素交换；
 * 然后找剩下的最小的元素，将其与第二个元素交换；
 * 以此类推...
 *
 * N次交换，(N^2)/2次比较
 *
 * @author: leon
 * @date: 2018/4/12 18:15
 * @version: 1.0
 */

public class SelectionSort {
    static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            //寻找最小值，然后和首元素交换
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[minIndex])
                    minIndex = j;
            }
            exch(array, minIndex, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = Test.createArray(100000, Integer.MAX_VALUE);
        Test.print(arr);
        sort(arr);
        assert Test.isSorted(arr);
        Test.print(arr);
    }

    private static void exch(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}

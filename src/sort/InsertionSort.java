package sort;

/**
 * 插入排序
 *
 * 将要排序的元素与已排好序的序列依次进行比较，然后将有序数列右移，然后插入新元素
 *
 * 交换次数：N
 * 比较次数：最坏情况下为(1+2+...+N-1 = N^2 / 2), 最好情况下为N(本身有序)
 *
 * 结论: 插入排序在序列部分有序的情况下效率很高
 *
 * 插入排序比冒泡排序、选择排序要快
 *
 * @author: leon
 * @date: 2018/4/12 18:15
 * @version: 1.0
 */
public class InsertionSort {
    static void sortBetter(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //与排好序的序列从后往前依次比较(因为前面的已经排好序了，不满足即刻停止)
            //注意: 全部移动完毕才进行交换
            int cur = arr[i];
            int j;
            for (j = i-1; j >= 0 && cur < arr[j]; j--)
                arr[j+1] = arr[j];
            arr[j+1] = cur;
        }
    }

    static void sortBad(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //与排好序的序列从后往前依次比较(因为前面的已经排好序了，不满足即刻停止)
            for (int j = i; j > 0 && arr[j] < arr[j-1]; j--)
                exch(arr, j, j-1);
        }
    }

    private static void exch(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = Test.createArray(10, 10);
        Test.print(arr);
        //sortBetter(arr);
        sortBad(arr);
        assert Test.isSorted(arr);
        Test.print(arr);
    }
}

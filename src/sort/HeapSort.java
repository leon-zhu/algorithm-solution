package sort;

/**
 * 堆排序, 最大堆 - 实现从小到大排序
 * 注意数组index=0的元素不参与排序
 *
 * @author: leon
 * @date: 2018/5/23 14:21
 * @version: 1.0
 */
public class HeapSort {

    public static void sort(int[] array) {
        /*构建最大堆*/
        int len = array.length-1; //注意: 书上可能有误
        for (int i = len/2; i >= 1; i--) {
            sink(array, i, len);
        }
        while (len > 1) {
            swap(array, 1, len);
            len--;
            sink(array, 1, len);
        }
    }

    /*将index=k的元素执行下沉操作*/
    private static void sink(int[] arr, int k, int size) {
        while (2*k <= size) {
            int j = 2*k;
            if (j+1 <= size && arr[j] < arr[j+1]) j++;
            if (arr[k] > arr[j]) break;
            swap(arr, k, j);
            k = j;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = Test.createArray(10, 100);
        Test.print(arr);
        sort(arr);
        assert Test.isSorted(arr);
        Test.print(arr);
    }
}

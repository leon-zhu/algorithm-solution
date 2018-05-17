package sort;

/**
 * 冒泡排序
 *
 * 两两比较，满足条件则交换（最后一个元素为最大或最小值）
 * (N^2)/2 交换跟顺序有关，最差情况是(N^2)/2,跟比较一样   (N^2)/2 比较
 *
 * @author: leon
 * @date: 2018/4/12 18:15
 * @version: 1.0
 */

public class BubbleSort {

    private static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                //相邻元素进行比较
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = Test.createArray(10, 100);
        Test.print(arr);
        sort(arr);
        assert Test.isSorted(arr);
        Test.print(arr);
    }


}

package sort;

/**
 * description here
 *
 * @author: leon
 * @date: 2018/4/16 21:04
 * @version: 1.0
 */
public class QuickSort {

    static void sort(int[] array) {
        sort(array, 0, array.length-1);
    }

    private static void sort(int[] array, int left, int right) {
        if (left >= right)
            return;
        int j = partition(array, left, right);
        sort(array, left, j-1);
        sort(array, j+1, right);
    }

    private static int partition(int[] array, int left, int right) {
        //选取第一个元素，然后两个指针，分别从两边向中间遍历，然后满足条件后交换位置
        //最后保证j左边的元素全部小于其右边的元素
        int i = left, j = right+1;
        int value = array[left];
        while (true) {
            while (array[++i] < value)
                if (i == right) break;
            while (array[--j] > value)
                if (j == left) break;
            if (i >= j) break;
            swap(array, i, j);
        }
        swap(array, left, j);
        return j;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = Test.createArray(100000, 10000);
        //Test.print(arr);
        sort(arr);
        assert Test.isSorted(arr);
        //Test.print(arr);
    }
}

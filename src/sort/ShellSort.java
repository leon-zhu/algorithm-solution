package sort;

/**
 * 希尔排序
 *
 * 基于插入排序的改进
 * 插入排序的缺点: 对于大规模乱序数组来说，它只能交换相邻的元素，因此元素只能一点一点的移动到
 * 正确的位置上。比如：如果最小的元素位于数组最后，要把它移动的正确的位置，就需要 N-1 步。
 *
 * 希尔排序的思想是使数组中任意间隔为h的元素都是有序的。在进行排序时，如果h很大，我们就能把元素移动到很远的地方，
 * 为实现更小的h有序创造方便。
 *
 * 排序算法是否稳定: 相同数字的相对次序会不会发生变化
 *
 *
 * 性能分析: 目前最重要的结论是它(下面实现的算法)的运行时间达不到平方级别(h/3)。
 * 已知最坏的情况下，下面算法的比较次数和N的3/2次方成正比
 *
 * @author: leon
 * @date: 2018/4/12 19:43
 * @version: 1.0
 */

public class ShellSort {
    static void sort(int[] arr) {
        int h = arr.length;
        while (h < arr.length / 3)
            h = 3*h + 1; //能保证while循环里的h最终能等于1
        while (h >= 1) {
            for (int i = 1; i < arr.length; i++) {
                int cur = arr[i];
                int j;
                for (j = i-h; j >= 0 && cur < arr[j]; j -= h) {
                    arr[j+h] = arr[j];
                }
                arr[j+h] = cur;
            }
            h /= 3;
        }
    }

    public static void main(String[] args) {
        int[] arr = Test.createArray(10, 100);
        Test.print(arr);
        ShellSort.sort(arr);
        Test.print(arr);
        assert Test.isSorted(arr);
    }
}

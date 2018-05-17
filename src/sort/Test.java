package sort;

import java.util.Random;
class Test {
    static int[] createArray(int len, int bound) {
        int[] array = new int[len];
        Random rand = new Random();
        for (int i = 0; i < len; i++) {
            array[i] = rand.nextInt(bound);
        }
        return array;
    }

    static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i+1])
                return false;
        }
        return true;
    }

    static void print(int[] arr) {
        for (int e : arr)
            System.out.print(e + " ");
        System.out.println();
    }

    /**
     *
     * @param sortName 排序算法
     * @param arr 待排序数组
     * @return 消耗时间
     */
    private static long time(String sortName, int[] arr) {
        long startTime = System.currentTimeMillis();
        if (sortName.equals("select"))
            SelectionSort.sort(arr);
        else if (sortName.equals("insert"))
            InsertionSort.sortBetter(arr);
        else if (sortName.equals("shell"))
            ShellSort.sort(arr);
        else if (sortName.equals("merge"))
            MergeSort.sort(arr);
        else if (sortName.equals("quick"))
            QuickSort.sort(arr);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static void main(String[] args) {
        int len = 100000; //数组长度
        int bound = Integer.MAX_VALUE; //数组元素大小上界
        int[] arr = Test.createArray(len, bound);
        System.out.println("select: " + Test.time("select", arr));

        arr = Test.createArray(len, bound);
        System.out.println("insert: " + Test.time("insert", arr));

        arr = Test.createArray(len*100, bound);
        System.out.println("shell: " + Test.time("shell", arr));

        arr = Test.createArray(len*100, bound);
        System.out.println("merge: " + Test.time("merge", arr));

        arr = Test.createArray(len*100, bound);
        System.out.println("quick: " + Test.time("quick", arr));
    }
}

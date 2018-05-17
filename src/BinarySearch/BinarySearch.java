package BinarySearch;

/**
 * description here
 *
 * @author: leon
 * @date: 2018/5/17 19:03
 * @version: 1.0
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 8, 8, 9};
        System.out.println(search(arr, 9));
    }

    private static int search(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > array[mid]) left = mid + 1;
            else if (target < array[mid]) right = mid - 1;
            else return mid;
        }
        return -1;
    }
}

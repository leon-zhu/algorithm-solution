package PriorityQueue;

/**
 * 定义一个基于最大堆实现的优先队列
 *
 * @author: leon
 * @date: 2018/5/23 13:07
 * @version: 1.0
 */
class PQ {
    private int N; //队列中已有的元素
    private Integer[] pq; //队列数组, 从1开始

    public PQ() {
    }

    public PQ(int max) {
        pq = new Integer[max+1];
    }

    /*将value值入列*/
    public void offer(int value) {
        pq[++N] = value;
        swim(N);
    }

    /*对index=k的元素进行上浮操作, 一旦比父节点大, 那么就与父节点交换值*/
    private void swim(int k) {
        while (k > 1 && pq[k] > pq[k/2]) {
            swap(k, k/2);
            k = k/2;
        }
    }

    /*从优先队列中弹出元素*/
    public int poll() {
        int value = pq[1];
        pq[1] = pq[N];
        pq[N] = null;
        N--;
        sink(1);
        return value;
    }

    /*对index=k的元素进行下沉操作*/
    private void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (j+1 <= N && pq[j] < pq[j+1]) j++;
            if (pq[k] > pq[j]) break;
            swap(k, j);
            k = j;
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void swap(int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
}

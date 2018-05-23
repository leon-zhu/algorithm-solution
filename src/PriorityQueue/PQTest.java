package PriorityQueue;

import java.util.Random;

/**
 * 最大堆实现的优先队列
 *
 * @author: leon
 * @date: 2018/5/23 12:51
 * @version: 1.0
 */
public class PQTest {
    public static void main(String[] args) {
        System.out.println("--------------利用优先队列进行排序-------------");
        PQ pq = new PQ(10); //定义一个大小为10的基于最大堆的优先队列
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            pq.offer(rand.nextInt(100));
        }

        for (int i = 0; i < 10; i++) {
            System.out.print(pq.poll() + " ");
        }

        System.out.println("\n-------从一堆数中选取5个最小值(利用最大堆)--------");
        System.out.print("添加元素为: ");
        pq = new PQ(10);
        for (int i = 0; i < 10; i++) {
            int value = rand.nextInt(100);
            System.out.print(value + " ");
            pq.offer(value);
            if (pq.size() > 5)
                pq.poll(); //弹出当前最大值
        }
        System.out.print("\n输入结果: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(pq.poll() + " ");
        }
    }

}



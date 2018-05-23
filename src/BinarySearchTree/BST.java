package BinarySearchTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * 二叉查找树
 *
 * @author: leon
 * @date: 2018/5/23 15:46
 * @version: 1.0
 */
public class BST<Key extends Comparable<Key>, Value> {

    /*定义一个二叉树节点, 包含键、值、两条链接、节点数*/
    private class Node {
        private Key key; //键
        private Value val; //值
        private Node left, right; //指向子树的链接
        private int N; //以该节点为根的子树中的节点总数

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    private Node root;

    /*该BST的总节点数*/
    public int size() {
        return size(root);
    }
    private int size(Node x) {
        if (x == null)  return 0;
        else            return x.N;
    }

    /*查找BST, 并返回key所对应的值*/
    public Value get(Key key) {
        return get(root, key);
    }
    /*从BST的root节点, 开始查找节点key所对应的value值*/
    private Value get(Node root, Key key) {
        if (root == null) return null;
        int cmp = key.compareTo(root.key);
        if (cmp > 0) return get(root.right, key);
        else if (cmp < 0) return get(root.left, key);
        else return root.val;
    }


    /*向BST中插入一个节点(key, val), 如果存在key, 那么则执行更新*/
    public void put(Key key, Value val) {
        root = put(root, key, val);
    }
    private Node put(Node root, Key key, Value val) {
        if (root == null) return new Node(key, val, 1); //注意: 以该节点为根节点的子树的节点数为1
        int cmp = key.compareTo(root.key); //用key进行比较
        if (cmp > 0) root.right = put(root.right, key, val);
        else if (cmp < 0) root.left = put(root.left, key, val);
        else root.val = val; //覆盖
        root.N = size(root.left) + size(root.right) + 1; //有些疑惑
        return root;
    }

    /*查找BST中最小的键key*/
    public Key min() {
        return min(root).key;
    }
    private Node min(Node root) {
        if (root.left == null) return root;
        return min(root.left);
    }

    /*返回BST中排名为k的键, 排名下标从0开始*/
    public Key select(int k) {
        return select(root, k).key;
    }
    private Node select(Node root, int k) {
        if (root == null) return null;
        int t = size(root.left);
        if (t > k) return select(root.left, k);
        else if (t < k) return select(root.right, k-t-1);
        else return root;
    }

    /*查找BST中key的排名, 都是从index=0开始*/
    public int rank(Key key) {
        return rank(root, key);
    }
    private int rank(Node root, Key key) {
        if (root == null) return 0;
        int cmp = key.compareTo(root.key);
        if (cmp < 0) return rank(root.left, key);
        else if (cmp > 0) return 1 + size(root.left) + rank(root.right, key);
        else return size(root.left);
    }

    /*删除BST中最小key对应的节点*/
    public void delMin() {
        root = delMin(root);
    }
    private Node delMin(Node root) {
        if (root.left == null) return root.right;
        root.left = delMin(root.left);
        root.N = 1 + size(root.left) + size(root.right);
        return root;
    }

    /*删除BST中key对应的节点 -- 删除操作最复杂*/
    public void delete(Key key) {
        root = delete(root, key);
    }
    private Node delete(Node root, Key key) {
        if (root == null) return null;
        int cmp = key.compareTo(root.key);
        if (cmp < 0) root.left = delete(root.left, key);
        else if (cmp > 0) root.right = delete(root.right, key);
        else {
            //找到要删除的元素
            if (root.right == null) return root.left;
            if (root.left == null) return root.right;
            //以下四句话要好好理解
            Node t = root;
            root = min(t.right);
            root.right = delMin(t.right);
            root.left = t.left;
        }
        root.N = size(root.left) + size(root.right) + 1;
        return root;
    }

    /*返回BST中键值位于lo<=key<=hi之间的所有节点*/
    public Iterable<Key> keys(Node root, Key lo, Key hi) {
        Queue<Key> queue = new LinkedList<>(); //Key的查询结果集
        keys(root, queue, lo, hi);
        System.out.println("key的范围结果为: ");
        while (queue.size() > 0) {
            System.out.print(queue.poll() + " ");
        }
        return queue;
    }
    private void keys(Node root, Queue<Key> queue, Key lo, Key hi) {
        if (root == null) return;
        int lval = lo.compareTo(root.key);
        int rval = hi.compareTo(root.key);
        if (lval < 0) keys(root.left, queue, lo, hi);
        if (lval <= 0 && rval >= 0) queue.offer(root.key);
        if (rval > 0) keys(root.right, queue, lo, hi);
    }


    public static void main(String[] args) {
        BST<Integer, Object> bst = new BST<>();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            bst.put(rand.nextInt(10), i*i);
        }
        System.out.println("min_key = " + bst.min());
        System.out.println("select(1): " + bst.select(0));
        System.out.println("rank(key): " + bst.rank(5));
        bst.inOrder(bst.root);
        //bst.delMin();
        bst.delete(5);
        System.out.println("\n删除某元素后");
        bst.inOrder(bst.root);

        bst.keys(bst.root, 0, 100);

    }

    /*BST从小到大输出: 中序打印*/
    private void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.println(root.key + " ");
        inOrder(root.right);
    }

}

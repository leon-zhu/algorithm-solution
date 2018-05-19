package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树相关操作: 包括创建, 遍历(先序-中序-后序-层序)
 *
 * @author: leon
 * @date: 2018/4/1 14:55
 * @version: 1.0
 */

public class BinaryTree<T> {

    /**
     * 使用先序的递归方式创建二叉树
     *
     * @param list <T>
     * @return TreeNode
     */
    TreeNode<T> createBinaryTreeUsingPreOrder(LinkedList<T> list) {
        TreeNode<T> root = null;
        T data = list.remove();
        if (data != null) {
            root = new TreeNode<>(data, null, null);
            root.left = createBinaryTreeUsingPreOrder(list);
            root.right = createBinaryTreeUsingPreOrder(list);
        }
        return root;
    }


    /**
     * 先序遍历 - 递归
     *
     * @param root root node of binary tree
     */
    void preOrder(TreeNode<T> root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历 - 递归
     *
     * @param root root node of binary tree
     */
    void inOrder(TreeNode<T> root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    /**
     * 后序遍历 - 递归
     *
     * @param root root node of binary tree
     */
    void postOrder(TreeNode<T> root) {
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    /**
     * 先序遍历 - 迭代
     * @param root root node of binary tree
     */
    void preOrderIteration(TreeNode<T> root) {
        Stack<TreeNode<T>> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                System.out.print(root.data + " ");
                root = root.left;
            } else {
                root = stack.pop();
                root = root.right;
            }
        }
    }

    /**
     * 中序遍历 - 迭代
     *
     * @param root 根节点
     */
    void inOrderIteration(TreeNode<T> root) {
        Stack<TreeNode<T>> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.print(root.data + " ");
                root = root.right;
            }
        }
    }

    /**
     * stack1 弹出顺序为根 - 右 - 左
     * stack2 弹出顺序为左 - 右 - 根
     *
     * @param root 根节点
     */
    void postOrderIteration(TreeNode<T> root) {
        Stack<TreeNode<T>> s1 = new Stack<>();
        Stack<TreeNode<T>> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            root = s1.pop();
            if (root.left != null)
                s1.push(root.left);
            if (root.right != null)
                s1.push(root.right);
            s2.push(root);
        }
        while (!s2.isEmpty()) {
            System.out.print(s2.pop().data + " ");
        }
    }

    /**
     * 层序遍历: 从左到右, 从上到下
     *
     * @param root 根节点
     */
    void levelOrder1(TreeNode<T> root) {
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            System.out.print(root.data + " ");
            if (root.left != null)
                queue.offer(root.left);
            if (root.right != null)
                queue.offer(root.right);
        }
    }


    /**
     * 层序遍历: 按层打印
     *
     * @param root 根节点
     */
    void levelOrder2(TreeNode<T> root) {
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                root = queue.poll();
                System.out.print(root.data + " ");
                if (root.left != null)
                    queue.offer(root.left);
                if (root.right != null)
                    queue.offer(root.right);
            }
            System.out.println();
        }
    }


}

/**
 * 二叉树节点的定义
 *
 * @param <T>
 */
class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;
    TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

package BinaryTree;

import java.util.LinkedList;
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
        if (root != null)
            stack.push(root);
        while (!stack.empty()) {
            root = stack.pop();
            System.out.print(root.data + " ");
            if (root.right != null)
                stack.push(root.right);
            if (root.left != null)
                stack.push(root.left);
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

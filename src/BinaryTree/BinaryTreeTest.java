package BinaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import static java.lang.System.*;


/**
 * 测试二叉树的相关操作
 *
 * @author: leon
 * @date: 2018/4/1 14:55
 * @version: 1.0
 */

public class BinaryTreeTest {
    public static void main(String[] args) {

        Integer[] input = {1, 2, 4, null, null, 5, null, null, 3, 6, null, null, 7, null, null}; //先序顺序
        //Integer[] input = {1, 2, 4, 5, 3, 6, 7}; //不对
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(input));
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        TreeNode<Integer> root = binaryTree.createBinaryTreeUsingPreOrder(list);
        //递归
        out.print("先序: ");
        binaryTree.preOrder(root);
        out.print("\n中序: ");
        binaryTree.inOrder(root);
        out.print("\n后序: ");
        binaryTree.postOrder(root);
        //迭代
        out.print("\n先序-迭代: ");
        binaryTree.preOrderIteration(root);
        out.print("\n中序-迭代: ");
        binaryTree.inOrderIteration(root);
        out.print("\n后序-迭代: ");
        binaryTree.postOrderIteration(root);
        out.print("\n层序1: ");
        binaryTree.levelOrder1(root);
        out.print("\n层序2: \n");
        binaryTree.levelOrder2(root);


    }
}

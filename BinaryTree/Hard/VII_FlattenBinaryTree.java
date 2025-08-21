package Hard;

import Traversals.TreeNode;

import java.util.*;

// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
public class VII_FlattenBinaryTree
{
    void preorder(TreeNode node, Queue<TreeNode> qe)
    {
        if(node == null) return;
        qe.offer(node);
        preorder(node.left, qe);
        preorder(node.right, qe);
    }
    public void flatten(TreeNode root) {
        if(root == null) return;
        Queue<TreeNode> qe = new LinkedList<>();

        preorder(root, qe);
        qe.poll();
        TreeNode k = root;
        while(qe.isEmpty() == false)
        {
            TreeNode temp = qe.poll();
            k.left = null;
            k.right = temp;
            k = temp;
        }
    }
}

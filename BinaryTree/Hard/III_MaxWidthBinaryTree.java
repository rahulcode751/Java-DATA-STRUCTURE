package Hard;

import Medium.Pair;
import Traversals.TreeNode;

import java.util.*;

// https://leetcode.com/problems/maximum-width-of-binary-tree/description/
public class III_MaxWidthBinaryTree
{
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));
        int maxWidth = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            int leftIndex = q.peek().getValue();
            int rightIndex = leftIndex;

            for(int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> p = q.poll();
                TreeNode node = p.getKey();
                int index = p.getValue();

                rightIndex = index;

                if(node.left != null) {
                    q.add(new Pair<>(node.left, 2 * index + 1));
                }

                if(node.right != null) {
                    q.add(new Pair<>(node.right, 2 * index + 2));
                }
            }

            maxWidth = Math.max(maxWidth,rightIndex - leftIndex + 1);
        }

        return maxWidth;
    }
}

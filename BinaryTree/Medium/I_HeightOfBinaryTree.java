package Medium;

import Traversals.TreeNode;

public class I_HeightOfBinaryTree
{
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

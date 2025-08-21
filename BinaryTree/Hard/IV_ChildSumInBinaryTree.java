package Hard;

import Traversals.TreeNode;

public class IV_ChildSumInBinaryTree
{
    static int flag;
    public static int solve(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;

        int left = solve(root.left);
        int right = solve(root.right);

        if(left + right != root.val) flag = 0;

        return left+right;
    }
    public static int isSumProperty(TreeNode root)
    {
        // add your code here
        flag = 1;
        solve(root);
        return flag;
    }
}

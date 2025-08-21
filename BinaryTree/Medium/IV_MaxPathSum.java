package Medium;

import Traversals.TreeNode;

// https://leetcode.com/problems/binary-tree-maximum-path-sum/
public class IV_MaxPathSum
{
    int maxi = -1000;
    public int solve(TreeNode root){
        if(root == null) return 0;

        int val = root.val;
        int left = Math.max(0,solve(root.left));
        int right = Math.max(0,solve(root.right));

        maxi = Math.max(val+left+right,maxi);
        return Math.max(left,right) + val;
    }
    public int maxPathSum(TreeNode root) {
        maxi = -1000;
        solve(root);
        return maxi;
    }
}

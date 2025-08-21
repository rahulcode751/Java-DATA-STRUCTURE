package Medium;

import Traversals.TreeNode;

// https://leetcode.com/problems/same-tree/description/
public class V_SameTree
{
    public boolean solve(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p == null && q != null) return false;
        if(p != null && q == null) return false;
        if(p.val != q.val) return false;

        if(solve(p.left,q.left) == true && solve(p.right,q.right) == true){
            return true;
        }
        return false;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return solve(p,q);
    }
}

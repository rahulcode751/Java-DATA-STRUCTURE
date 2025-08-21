package Medium;

import Traversals.TreeNode;

public class VII_Symetrictree
{
    public boolean solve(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p == null && q != null) return false;
        if(p != null && q == null) return false;
        if(p.val != q.val) return false;

        if(solve(p.left,q.right) == true  && solve(p.right,q.left) == true ){
            return true;
        }
        return false;
    }
    public boolean isSymmetric(TreeNode root) {
        return solve(root.left,root.right);
    }
}

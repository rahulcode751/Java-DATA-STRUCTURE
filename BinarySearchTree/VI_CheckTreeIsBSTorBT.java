import Traversals.TreeNode;

// https://leetcode.com/problems/validate-binary-search-tree/description/
public class VI_CheckTreeIsBSTorBT
{
    public boolean solve(TreeNode root, long left, long right){
        if(root == null) return true;
        if(left >= root.val || root.val >= right) return false;
        if((solve(root.left,left,root.val)) && solve(root.right,root.val,right)){
            return true;
        }
        return false;
    }
    public boolean isValidBST(TreeNode root) {
        return solve(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }
}

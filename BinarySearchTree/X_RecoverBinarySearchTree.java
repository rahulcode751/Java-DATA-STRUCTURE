import Traversals.TreeNode;

// https://leetcode.com/problems/recover-binary-search-tree/
public class X_RecoverBinarySearchTree
{
    public TreeNode prev,first,mid,next;
    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        if(prev != null && prev.val > root.val){
            if(mid == null){
                first = prev;
                mid = root;
            }else{
                next = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
    public void recoverTree(TreeNode root) {
        first = prev = mid = next = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if(next != null){
            int temp = next.val;
            next.val = first.val;
            first.val = temp;
        }else{
            int temp = mid.val;
            mid.val = first.val;
            first.val = temp;
        }
    }
}

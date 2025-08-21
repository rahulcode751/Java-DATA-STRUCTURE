import Traversals.TreeNode;

// https://leetcode.com/problems/insert-into-a-binary-search-tree/description/
public class II_InsertIntoBST
{
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        TreeNode cur = root;
        while(root != null){
            if(root.val <= val){
                if(root.right != null) root = root.right;
                else{
                    root.right = new TreeNode(val);
                    break;
                }
            }else{
                if(root.left != null) root = root.left;
                else{
                    root.left = new TreeNode(val);
                    break;
                }
            }
        }
        return cur;
    }
}

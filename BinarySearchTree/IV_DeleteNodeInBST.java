import Traversals.TreeNode;

// https://leetcode.com/problems/delete-node-in-a-bst/description/
public class IV_DeleteNodeInBST
{
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(root.val == key){
            return helper(root,key);
        }

        TreeNode cur = root;
        while(root != null){
            if(root.val > key){
                if(root.left != null && root.left.val == key){
                    root.left = helper(root.left,key);
                    break;
                }else{
                    root = root.left;
                }
            }else{
                if(root.right != null && root.right.val == key){
                    root.right = helper(root.right,key);
                    break;
                }else{
                    root = root.right;
                }
            }
        }
        return cur;
    }

    public TreeNode helper(TreeNode root, int key){
        if(root.left == null) return root.right;
        if(root.right == null) return root.left;

        TreeNode right = root.right;
        TreeNode lastRight = leftSubTree(root.left);
        lastRight.right = right;
        root.right = null;
        return root.left;
    }
    public TreeNode leftSubTree(TreeNode root){
        if(root.right == null) return root;
        return leftSubTree(root.right);
    }
}

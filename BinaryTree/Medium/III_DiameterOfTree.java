package Medium;

import Traversals.TreeNode;

public class III_DiameterOfTree
{
    int maxi;
    public int diameter(TreeNode root){
        if(root == null) return 0;
        int left = diameter(root.left);
        int right = diameter(root.right);

        maxi = Math.max(maxi,left+right);

        return 1 + Math.max(left,right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        maxi = 0;
        diameter(root);
        return maxi;
    }
}

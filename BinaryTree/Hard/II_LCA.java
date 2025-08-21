package Hard;

import Traversals.TreeNode;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
public class II_LCA
{
        public TreeNode solve(TreeNode root, TreeNode p, TreeNode q){
            if(root == null) return null;

            if(root == p || root == q) return root;

            TreeNode pp = solve(root.left,p,q);
            TreeNode qq = solve(root.right,p,q);

            if(pp != null && qq != null) return root;
            if(pp != null) return pp;
            if(qq != null) return qq;
            return null;
        }
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            return solve(root,p,q);
        }
}

package Hard;

import Traversals.TreeNode;

import java.util.*;

// https://www.geeksforgeeks.org/problems/burning-tree/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=burning-tree
public class VI_BurningTree
{
    public static TreeNode storeParent(Map<TreeNode,TreeNode> parent, TreeNode root,int target){
        if(root == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode targetTreeNode = null;

        while(q.isEmpty() == false){
            TreeNode TreeNode = q.poll();
            if(TreeNode.val == target) targetTreeNode = TreeNode;
            if(TreeNode.left != null){
                parent.put(TreeNode.left,TreeNode);
                q.offer(TreeNode.left);
            }
            if(TreeNode.right != null){
                parent.put(TreeNode.right,TreeNode);
                q.offer(TreeNode.right);
            }
        }
        return targetTreeNode;
    }
    public static int distance(TreeNode root, int target) {
        Map<TreeNode,TreeNode> parent = new HashMap<>();
        TreeNode targetTreeNode = storeParent(parent,root,target);
        Map<TreeNode,Boolean> vis = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(targetTreeNode);
        vis.put(targetTreeNode,true);
        int curr_level = 0;
        while(q.isEmpty() == false){
            int sz = q.size();
            curr_level++;

            for(int i=0; i<sz; i++){
                TreeNode TreeNode = q.poll();
                if(TreeNode.left != null && vis.get(TreeNode.left) == null){
                    q.offer(TreeNode.left);
                    vis.put(TreeNode.left,true);
                }
                if(TreeNode.right != null && vis.get(TreeNode.right) == null){
                    q.offer(TreeNode.right);
                    vis.put(TreeNode.right,true);
                }
                if(parent.get(TreeNode) != null && vis.get(parent.get(TreeNode)) == null){
                    vis.put(parent.get(TreeNode),true);
                    q.offer(parent.get(TreeNode));
                }
            }
        }

        return curr_level;
    }
    public static int minTime(TreeNode root, int target) {
        // code here
        return distance(root,target)-1;
    }
}

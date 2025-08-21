package Hard;

import Traversals.TreeNode;

import java.util.*;

// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
public class V_AllNodeDistanceKInBinaryTree
{
    public void storeParent(Map<TreeNode,TreeNode> parent, TreeNode root){
        if(root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        parent.put(root,null);
        q.offer(root);
        while(q.isEmpty() == false){
            TreeNode node = q.poll();
            if(node.left != null){
                parent.put(node.left,node);
                q.offer(node.left);
            }
            if(node.right != null){
                parent.put(node.right,node);
                q.offer(node.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parent = new HashMap<>();
        storeParent(parent,root);
        Map<TreeNode,Boolean> vis = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        vis.put(target,true);
        int curr_level = 0;
        while(q.isEmpty() == false){
            int sz = q.size();
            if(curr_level == k) break;
            curr_level++;

            for(int i=0; i<sz; i++){
                TreeNode node = q.poll();
                if(node.left != null && vis.get(node.left) == null){
                    q.offer(node.left);
                    vis.put(node.left,true);
                }
                if(node.right != null && vis.get(node.right) == null){
                    q.offer(node.right);
                    vis.put(node.right,true);
                }
                if(parent.get(node) != null && vis.get(parent.get(node)) == null){
                    vis.put(parent.get(node),true);
                    q.offer(parent.get(node));
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
    }
}

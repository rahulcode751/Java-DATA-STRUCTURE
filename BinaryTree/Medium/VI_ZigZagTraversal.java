package Medium;

import Traversals.TreeNode;
import java.util.*;

// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
public class VI_ZigZagTraversal
{
    public List<List<Integer>> solve(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean flag = false;
        while(q.isEmpty() == false){
            int sz = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0; i<sz; i++){
                TreeNode node = q.poll();
                temp.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            if(flag == true){
                Collections.reverse(temp);
                ans.add(temp);
            }
            else ans.add(temp);
            flag = !flag;
        }
        return ans;
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        return solve(root);
    }
}

package Medium;

// https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1

import Traversals.TreeNode;

import java.util.*;

public class VII_TopView
{
    static public ArrayList<Integer> solve(TreeNode root){
        Map<Integer,Integer> mp = new TreeMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));

        while(q.isEmpty() == false){
            Pair<TreeNode, Integer> p = q.poll();
            TreeNode node = p.getKey();
            Integer level = p.getValue();

            if(mp.containsKey(level) == false){
                mp.put(level, node.val);
            }

            if(node.left != null){
                q.add(new Pair<>(node.left,level - 1));
            }
            if(node.right != null){
                q.add(new Pair<>(node.right,level + 1));
            }

        }
        for (Integer value : mp.values()) {
            ans.add(value);
        }
        return ans;
    }
    static ArrayList<Integer> topView(TreeNode root) {
        return solve(root);
    }
}

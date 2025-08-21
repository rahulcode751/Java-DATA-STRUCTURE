package Hard;

import Traversals.TreeNode;

import java.util.*;

// https://www.geeksforgeeks.org/problems/root-to-leaf-paths/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=root-to-leaf-paths
public class I_RootToLeafPaths
{
    public static ArrayList<ArrayList<Integer>> global;
    public static void solve(TreeNode root, ArrayList<Integer> ans){
        if(root == null) return;
        if(root.left == null && root.right == null){
            ans.add(root.val);
            global.add(new ArrayList<>(ans));
            ans.remove(ans.size()-1);
            return;
        }
        ans.add(root.val);
        solve(root.left,ans);
        solve(root.right,ans);
        ans.remove(ans.size()-1);
    }
    public static ArrayList<ArrayList<Integer>> Paths(TreeNode root) {
        global = new ArrayList<>();
        if(root == null) return global;
        ArrayList<Integer> ans = new ArrayList<>();
        solve(root,ans);
        return global;
    }
}

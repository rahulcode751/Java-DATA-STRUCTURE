import Traversals.TreeNode;

// https://www.geeksforgeeks.org/problems/implementing-ceil-in-bst/1
public class I_CeilInBST
{
    int ans;
    public void solve(TreeNode root, int key){
        if(root == null) return;
        if(root.val == key){
            ans = key;
            return;
        }
        if(root.val < key){
            solve(root.right,key);
        }else{
            ans = Math.min(ans,root.val);
            solve(root.left,key);
        }
    }
    int findCeil(TreeNode root, int key) {
        ans = Integer.MAX_VALUE;
        solve(root,key);
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
}

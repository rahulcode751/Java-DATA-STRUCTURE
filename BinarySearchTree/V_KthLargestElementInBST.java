import Traversals.TreeNode;

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
public class V_KthLargestElementInBST
{
    public int ans = 0,p;
    public void solve(TreeNode root, int k){
        if(root == null) return;
        solve(root.left,k);
        ans++;
        if(ans == k){
            p = root.val;
            return;
        }
        solve(root.right,k);
    }
    public int kthSmallest(TreeNode root, int k) {
        p = 0;
        solve(root,k);
        return p;
    }
}

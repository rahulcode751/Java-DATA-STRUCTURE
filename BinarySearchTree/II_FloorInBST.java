import Traversals.TreeNode;

public class II_FloorInBST
{
    public static int ans;
    public static void solve(TreeNode root, int key){
        if(root == null) return;
        if(root.val == key){
            ans = key;
            return;
        }
        if(root.val < key){
            ans = Math.max(ans,root.val);
            solve(root.right,key);
        }else{
            solve(root.left,key);
        }
    }
    public static int floor(TreeNode root, int key) {
        ans = Integer.MIN_VALUE;
        solve(root,key);
        if(ans == Integer.MIN_VALUE) return -1;
        return ans;
    }
}

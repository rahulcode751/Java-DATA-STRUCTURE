import Traversals.TreeNode;

// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
public class ArrayIntoBst
{
    TreeNode helper(int[] arr, int s, int e){
        if(s > e){
            return null;
        }

        int mid = (s+e)/2;
        int rootData = arr[mid];
        TreeNode root = new TreeNode(rootData);
        root.left = helper(arr, s , mid-1);
        root.right = helper(arr, mid+1 , e);

        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
}

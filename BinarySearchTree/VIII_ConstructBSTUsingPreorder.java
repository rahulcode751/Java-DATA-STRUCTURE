import Traversals.TreeNode;

// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/
public class VIII_ConstructBSTUsingPreorder
{
    public TreeNode bstFromPreorder(int[] preorder) {
        return solve(preorder, 0, preorder.length-1);
    }
    public TreeNode solve(int[] preorder, int left, int right){
        if(left > right) return null;
        if(left == right) return new TreeNode(preorder[left]);

        TreeNode node = new TreeNode(preorder[left]);

        int leftStart = left + 1;
        int rightStart = right + 1;

        for(int i = leftStart; i <= right; i++){
            if(preorder[i] > preorder[left]){
                rightStart = i;
                break;
            }
        }

        int leftEnd = rightStart - 1;

        node.left = solve(preorder, leftStart, leftEnd);
        node.right = solve(preorder, rightStart, right);

        return node;
    }
}

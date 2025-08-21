package Hard;

import Traversals.TreeNode;

// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
public class IX_ConstructBTUsingPostInOrder
{
    TreeNode buildTreeHelper(int[] inOrder, int[] posOrder, int inS, int inE, int preS, int preE){
        if(inS > inE){
            return null;
        }
        int rootData = posOrder[preE];
        int rootIndex = -1;
        for(int i=inS;i<=inE;i++){
            if(inOrder[i] == rootData){
                rootIndex = i;
                break;
            }
        }
        int leftInS = inS;
        int leftInE = rootIndex - 1;
        int leftPreS = preS;
        int leftPreE = leftPreS + leftInE - leftInS;

        int rightInS = rootIndex + 1;
        int rightInE = inE;
        int rightPreS = leftPreE + 1;
        int rightPreE = preE-1;

        TreeNode root = new TreeNode(rootData);
        root.left = buildTreeHelper(inOrder,posOrder,leftInS,leftInE,leftPreS,leftPreE);
        root.right = buildTreeHelper(inOrder,posOrder,rightInS,rightInE,rightPreS,rightPreE);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return buildTreeHelper(inorder,postorder,0,n-1,0,n-1);
    }
}

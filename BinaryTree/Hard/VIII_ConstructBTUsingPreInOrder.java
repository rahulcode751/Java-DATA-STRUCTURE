package Hard;

import Traversals.TreeNode;

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class VIII_ConstructBTUsingPreInOrder
{
    TreeNode buildTreeHelper(int[] inOrder, int[] preOrder, int inS, int inE, int preS, int preE){
        if(inS > inE){   // means array is empty  or preS > preE to bhi empty array ye base case h
            return null;
        }
        int rootData = preOrder[preS];
        int rootIndex = -1;
        for(int i=inS;i<=inE;i++){
            if(inOrder[i] == rootData){
                rootIndex = i;
                break;
            }
        }
        int leftInS = inS;
        int leftInE = rootIndex - 1;
        int leftPreS = preS + 1;
        int leftPreE = leftPreS + leftInE - leftInS;

        int rightInS = rootIndex + 1;
        int rightInE = inE;
        int rightPreS = leftPreE + 1;
        int rightPreE = preE;

        TreeNode root = new TreeNode(rootData);
        root.left = buildTreeHelper(inOrder,preOrder,leftInS,leftInE,leftPreS,leftPreE);
        root.right = buildTreeHelper(inOrder,preOrder,rightInS,rightInE,rightPreS,rightPreE);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        return buildTreeHelper(inorder,preorder,0,n-1,0,n-1);
    }
}

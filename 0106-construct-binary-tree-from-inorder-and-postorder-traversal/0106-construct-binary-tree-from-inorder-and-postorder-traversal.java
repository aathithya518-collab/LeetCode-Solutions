import java.util.HashMap;
import java.util.Map;

class Solution {
    private int postIndex;
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        inorderIndexMap = new HashMap<>();

        // Store index of each value in inorder array for O(1) lookup
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildSubtree(postorder, 0, inorder.length - 1);
    }

    private TreeNode buildSubtree(int[] postorder, int inStart, int inEnd) {
        // Base case: no elements to construct subtree
        if (inStart > inEnd) {
            return null;
        }

        // The current root is the element at postIndex
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        // Find the split point in inorder traversal
        int rootIndex = inorderIndexMap.get(rootVal);

        // IMPORTANT: Must construct right subtree first because
        // in postorder traversal, right child immediately precedes root
        root.right = buildSubtree(postorder, rootIndex + 1, inEnd);
        root.left = buildSubtree(postorder, inStart, rootIndex - 1);

        return root;
    }
}
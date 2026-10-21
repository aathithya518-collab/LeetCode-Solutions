import java.util.HashMap;
import java.util.Map;

class Solution {
    private int preIndex = 0;
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        inorderIndexMap = new HashMap<>();

        // Map each value in inorder to its index for O(1) partition lookups
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildSubtree(preorder, 0, inorder.length - 1);
    }

    private TreeNode buildSubtree(int[] preorder, int inStart, int inEnd) {
        // Base case: no elements in this subtree boundary
        if (inStart > inEnd) {
            return null;
        }

        // Current root is at preorder[preIndex]
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = inorderIndexMap.get(rootVal);

        // Preorder order: Root -> Left -> Right
        // Construct left child first, then right child
        root.left = buildSubtree(preorder, inStart, rootIndex - 1);
        root.right = buildSubtree(preorder, rootIndex + 1, inEnd);

        return root;
    }
}
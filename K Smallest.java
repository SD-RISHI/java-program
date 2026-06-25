class Solution {

    // Tracks how many nodes have been visited
    int count = 0;

    // Stores kth smallest value
    int result = 0;

    public int kthSmallest(TreeNode root, int k) {

        // Perform inorder traversal
        inorder(root, k);

        return result;
    }

    public void inorder(TreeNode root, int k) {

        // Base case
        if (root == null)
            return;

        // Visit left subtree
        inorder(root.left, k);

        // Process current node
        count++;

        // Found kth smallest node
        if (count == k) {
            result = root.val;
            return;
        }

        // Visit right subtree
        inorder(root.right, k);
    }
}

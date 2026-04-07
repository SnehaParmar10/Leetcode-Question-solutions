class Solution {
    TreeNode head = new TreeNode(0);
    TreeNode curr = head;

    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        return head.right;


        
    }

    private void inorder(TreeNode node) {
        if(node == null) return;

        inorder(node.left);

        node.left = null;
        curr.right = node;
        curr = node;

        inorder(node.right);
    }
}
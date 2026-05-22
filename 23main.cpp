class Solution {
public:
    TreeNode* first = NULL;
    TreeNode* second = NULL;
    TreeNode* prev = NULL;

    void inorder(TreeNode* root) {
        if (root == NULL)
            return;

        inorder(root->left);

        // Detect swapped nodes
        if (prev != NULL && root->val < prev->val) {
            if (first == NULL) {
                first = prev;
            }
            second = root;
        }

        

        prev = root;

        inorder(root->right);
    }

    void recoverTree(TreeNode* root) {
        inorder(root);

        // Swap values of the two wrong nodes
        int temp = first->val;
        first->val = second->val;
        second->val = temp;
    }
};
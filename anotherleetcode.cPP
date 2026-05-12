class Solution {
public:

    vector<TreeNode*> build(int start, int end) {
        vector<TreeNode*> trees;

        // Base case
        if (start > end) {
            trees.push_back(NULL);
            return trees;
        }

        // Try each value as root
        for (int i = start; i <= end; i++) {

            // Generate all possible left and right subtrees
            vector<TreeNode*> leftTrees = build(start, i - 1);
            vector<TreeNode*> rightTrees = build(i + 1, end);

            // Combine left and right subtrees with root i
            for (auto left : leftTrees) {
                for (auto right : rightTrees) {

                    TreeNode* root = new TreeNode(i);

                    root->left = left;
                    root->right = right;

                    trees.push_back(root);
                }

                
            }
        }

        return trees;
    }

    vector<TreeNode*> generateTrees(int n) {
        if (n == 0) return {};
        return build(1, n);
    }
};
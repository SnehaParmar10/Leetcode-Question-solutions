class Solution {

    public List<Integer> preorder(Node root) {
        
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }
    private void helper(Node node, List<Integer> result) {
        if (node == null) return;

        result.add(node.val);

        for (Node child : node.children) {
            helper(child, result);
        }
    }
}
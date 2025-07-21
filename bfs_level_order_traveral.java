// We use bfs to traverse in level-order for the given tree
// TC: O(n) - as we are going over each node just once
// SC: O(n) - as we use a queue to store all n values - avg itll only store the values of each leavel and pop and add child nodes as we traverse but worst case - O(n)


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        
        List<List<Integer>> output = new ArrayList<>();
        // Store each level's nodes
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size() > 0){
            int count = queue.size();
            List<Integer> levelValues = new ArrayList<>();
            for(int i=0;i<count;i++){
                // For each node in the queue, we first remove the node and 
                // then add its children to the end of the queue
                TreeNode node = queue.poll();
                levelValues.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            output.add(levelValues);
        }
        return output;
    }
}

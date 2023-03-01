class Solution{
    public void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack();
        stack.push(root); // push 1
        
        // we want the left node first so adding right node first in the stack
        // It takes all the left nodes put it in the stack and set to the right sides and the right nodes to other right nodes , its kind of left to right dealing 
        while(!stack.isEmpty()){
            TreeNode curr_node = stack.pop();
            
            // push right node in stack
            if(curr_node.right != null){
                stack.push(curr_node.right); // push 5 first
            }
            // push left node in stack
            if(curr_node.left != null){
                stack.push(curr_node.left); // push 2 
            }
            if(!stack.isEmpty()){
                curr_node.right = stack.peek(); // peek is 2 
                // set 1.right to 2 and do it over and over again 
                // it will set all the right nodes and left nodes to null
            }
            curr_node.left = null;
        }
    }
}

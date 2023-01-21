 // 17 ms 
class Solution {
   int sum = 0;
   int count = 0; 
   int ans = 0;

    public void inorderAverage(TreeNode root){   
        if(root == null){
            return;
        }
        inorderAverage(root.left);
        sum += root.val;
        count++; 
        inorderAverage(root.right);
    }
    Queue<TreeNode> queue = new LinkedList<>(); 
    public int averageOfSubtree(TreeNode root) {
       inorder(root); // 4
       // 0 8 1 4 5 6
       while(!queue.isEmpty()){
           TreeNode node = queue.poll();
           inorderAverage(node);
           if((sum/count) == node.val) ans++;
           sum = 0;
           count = 0;
       }
       return ans;
    }

    public void inorder(TreeNode root){   
    if(root == null){
        return;
    }
    inorder(root.left);
    queue.add(root);
    inorder(root.right);
    }
}

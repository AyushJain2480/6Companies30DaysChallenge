class Solution {
    public int deepestLeavesSum(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            sum = 0;
            for(int i = 0;  i < size; i++){
                TreeNode pop = queue.poll();
                sum += pop.val;
                if(pop.left != null){
                  queue.offer(pop.left);
                }
                if(pop.right != null){
                    queue.offer(pop.right);
                }
            }
        }
        return sum;
    }
}

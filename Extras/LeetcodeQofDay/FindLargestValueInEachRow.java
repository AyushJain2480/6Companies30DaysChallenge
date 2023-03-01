class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++){
                TreeNode pop = queue.poll();
                max = Math.max(max , pop.val);
                if(pop.left != null){
                    queue.offer(pop.left);
                }
                if(pop.right != null){
                    queue.offer(pop.right);
                }
            }
            list.add(max);
        }
        return list;
    }
}

public class Codec {
    // Encodes a tree to a single string.
    // preorder
    StringBuilder sb = new StringBuilder();
    public String serialize(TreeNode root) {
        preorderBuildString(root);
        return sb.toString();
    }
    public void preorderBuildString(TreeNode root){
        if(root == null){
            sb.append("null" + ",");
            return;
        }
        sb.append(root.val + ",");
        serialize(root.left);
        serialize(root.right);
    }
    // "4,N,N"
    // Decodes your encoded data to tree.
    Queue<String> queue = new LinkedList();
    public TreeNode deserialize(String data) {
        queue.addAll(Arrays.asList(data.split(",")));
        return buildTree();
    }
    public TreeNode buildTree(){
        String val = queue.poll();
        if(val.equals("null")){
             return null;
        }else{
            TreeNode root = new TreeNode(Integer.valueOf(val));
            root.left = buildTree();
            root.right = buildTree();
            return root;
        }
    }   
}

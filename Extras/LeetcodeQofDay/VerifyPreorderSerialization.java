 // If a serialization is correct, diff should never be negative and diff will be zero when finished.
class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int vacancy = 1;
        for(String node : nodes){
            // visiting node
            vacancy--;
            // failure check
            if(vacancy < 0){
                return false;
            }
            if(!node.equals("#")){
                vacancy += 2;
            }
        }
        return vacancy == 0;
    }
}

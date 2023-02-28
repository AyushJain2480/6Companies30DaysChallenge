 // If a serialization is correct, diff should never be negative and diff will be zero when finished.

// In short, this is a checking number of hashtag(#) problem, because only hashtag(#) and numbers exist.
// We have the following constraints for preorder traversal of a binary tree:

// For any tree, number of nodes == number of edges + 1. (so we add 1 to number of edges first)
// The hashtag(#) should only appear when there's edge available.
// Then we have the algorithm or statement:

// each node consumes 1 edge
// each non-leaf node creates two edges
// whenever edges are smaller than 0, return false, which means number of hashtag(#) is too much
// Finally, edges should be zero to meet the 1st constraint which is number of nodes == number of edges + 1
 
 
class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int edges = 1;
        for(String node : nodes){
            // visiting node
            edges--;
            // failure check
            if(edges < 0){
                return false; // to prevent the case: [#,](https://leetcode.com/problems/powx-n) a, ...
            }
            if(!node.equals("#")){
                edges += 2; // generate two edges
            }
        }
        return edges == 0;
    }
}

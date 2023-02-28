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

// Further explanation
// This solution works for verifying a preorder serialization because it uses the fact that a valid serialization of a binary tree must satisfy two conditions:

// The number of non-null nodes in the tree is one more than the number of null nodes.

// The number of null nodes in the tree is one more than the number of edges in the tree.

// The algorithm splits the preorder string into an array of node values. It initializes a variable "edges" to 1, which represents the number of edges in an empty tree. It then loops through the nodes in the array, and for each node, it decrements the "edges" variable to account for the edge that connects the current node to its parent. If the "edges" variable becomes negative at any point, the algorithm returns false because it indicates that the number of null nodes in the tree exceeds the number of edges.

// If the current node is not null (i.e., it has a non-# value), the algorithm increments the "edges" variable by 2 to account for the two edges that connect the current node to its two children.

// Finally, the algorithm checks if the "edges" variable is 0, which indicates that the number of null nodes in the tree is one more than the number of edges, satisfying the second condition of a valid serialization. If the "edges" variable is not 0, the algorithm returns false.

// Overall, the algorithm checks both conditions of a valid serialization and returns true if the preorder string represents a valid binary tree and false otherwise.
 
 
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

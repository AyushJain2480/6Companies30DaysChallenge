My Leetcode post link: 
// https://leetcode.com/problems/number-of-ways-to-reach-a-position-after-exactly-k-steps/discuss/3140409/Java-Easy-Top-Down-Approach-or-Memoization

// This code defines a solution for finding the number of ways to reach a certain position endPos from another position startPos in k steps.

// The numberOfWays method takes in the startPos, endPos, and k as inputs and calculates the distance between startPos and endPos by taking the absolute value of the difference.

// It then creates a two-dimensional array d_k with 1001 rows and k + 1 columns, and initializes all the elements in the array to -1.

// The method then calls a private helper method numberOfWays(int d, int k, int[][] d_k) which takes in the distance, k, and the memory array d_k as inputs. This helper method uses a top-down approach, also known as memoization, 
// to find the number of ways to reach endPos from startPos in k steps.

// The numberOfWays method checks three cases:

// If d > k, the method returns 0 as it is not possible to reach endPos from startPos in k steps.

// If d == k, the method returns 1 as there is only one way to reach endPos from startPos in k steps, i.e., by taking k steps towards endPos.

// If d_k[d][k] is not equal to -1, the method returns the value stored in d_k[d][k]. This is because this sub-problem has already been solved and its result is stored in the memory array d_k.

// If none of the above conditions are met, the method calculates the number of ways to reach endPos from startPos in k steps by calling the numberOfWays method recursively for two cases:

// numberOfWays(d + 1, k - 1, d_k), which corresponds to taking a single step towards endPos.

// numberOfWays(Math.abs(d - 1), k - 1, d_k), which corresponds to taking a single step away from endPos.

// Finally, the method stores the result in d_k[d][k] and returns it, to avoid solving the same sub-problem multiple times. The result is also taken modulo 1_000_000_007 to avoid overflow.

// Code
class Solution {
    public int numberOfWays(int startPos, int endPos, int k) {
        int distance = Math.abs(endPos - startPos);
        int[][] d_k = new int[1001][k + 1]; 
        for (int[] kArr : d_k) {
            Arrays.fill(kArr, -1);
        }
        return numberOfWays(distance, k, d_k);
    }

    private int numberOfWays(int d, int k, int[][] d_k) {
        if (d > k) return 0;
        if (d == k) return 1;
        if (d_k[d][k] != -1) return d_k[d][k];
        d_k[d][k] = (numberOfWays(d + 1, k - 1, d_k) + numberOfWays(Math.abs(d - 1), k - 1, d_k)) % 1_000_000_007;
        return d_k[d][k];
    }
}

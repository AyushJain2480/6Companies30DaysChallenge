// Intuition
// When two ants meet at some point,
// they change their directions and continue moving again.
// But you can assume they don't change direction and keep moving.

// (You don't really know the difference of ants between one and the other, do you?)


// Explanation
// For ants in direction of left, the leaving time is left[i]
// For ants in direction of right, the leaving time is n - right[i]

class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int res = 0;
        for (int i: left)
            res = Math.max(res, i);
        for (int i: right)
            res = Math.max(res, n - i);
        return res;
    }
}

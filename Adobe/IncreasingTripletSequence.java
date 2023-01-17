class Solution {

        public boolean increasingTriplet(int[] nums) {
            if(nums.length < 3) return false;
        // start with two largest values, as soon as we find a number bigger than both, while both have been updated, return true.
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= small) { small = n; } // update small if n is smaller than both
            else if (n <= big) { big = n; } // update big only if greater than small but smaller than big
            else return true; // return if you find a number bigger than both
        }
        return false;
    }
    
}

// C1 = so far best candidate of end element of a one-cell subsequence to form a triplet subsequence

// C2 = so far best candidate of end element of a two-cell subsequence to form a triplet subsequence

// So c1 and c2 are the perfect summary of history.

// public class Solution {
//     public boolean increasingTriplet(int[] nums) {
//         int c1 = Integer.MAX_VALUE, c2 = Integer.MAX_VALUE;
//         for (int i : nums) 
//             if (i <= c1)
//                 c1 = i;
//             else if (i <= c2)
//                 c2 = i;
//             else
//                 return true;
//         return false;
//     }
// }

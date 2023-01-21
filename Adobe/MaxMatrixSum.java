// Traverse each element.
// Find count of negative numbers.
// Find minimum positive value element in the matrix.
// Sum absolute value of each cell.
// If negative count is even return Total Sum.
// Else we will subtract twice of Min Element.
class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int countNegative = 0;
        long absoluteSum = 0;
        int minimumPositiveValue = Integer.MAX_VALUE;
        for(int[] arr : matrix){
            for(int element : arr){
                if(element < 0) countNegative ++;
                absoluteSum += Math.abs(element);
                minimumPositiveValue = Math.min(Math.abs(element), minimumPositiveValue);
            }
        }
        if(countNegative % 2 == 0){
           return absoluteSum;
        }else{
           return absoluteSum - 2 * minimumPositiveValue;
        }
    }
}


class Solution {

    int res = 0;

    public int trailingZeroes(int n) {
        
        if(n < 5){
            return res;
        }

        int quotient = n/5;
        res = res + quotient;
        return trailingZeroes(n/5);

    }
    
}

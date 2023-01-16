class Solution {
    boolean validity(int number, int [][] statements, int n)
    {
        for (int i=0; i<n; i++)
        {
            int a = 1 << (n-1-i);
            int b = number & a;
            if(b>0)
            {
                for (int j=0; j<n; j++)
                {
                    int c = (number & (1<<(n-1-j)));
                    int j_asgn =  (c > 0)?1:0;
                    if (statements[i][j]!=2 && statements[i][j]!=j_asgn) return false;
                }
            }
        }
        return true;
    }
    public int maximumGood(int[][] statements) {
        int n = statements.length, res=0;
        for (int i=0; i<(1<<n); i++)
            if (validity(i, statements, n)) res = Math.max(res, Integer.bitCount(i));
        return res;
    }
}

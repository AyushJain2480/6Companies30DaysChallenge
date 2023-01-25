class Solution {
    public int numberOfCombinations(String num) {
        int n = num.length();
        int[][] cont = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            if (num.charAt(i) == '0') continue;
            int e = i;
            while (e < n && num.charAt(e) == num.charAt(i)) e++;
            int t = 1;
            cont[i][n - i] = t;
            for (int j = n - i - 1; j > 0; j--) {
                if (i + j + j > n) {
                    cont[i][j] = t;
                    continue;
                }
                int l = (i + j + j <= e) ? j : 0;
                while (l < j && num.charAt(i + l) == num.charAt(i + j + l)) l++;
                if (l == j || num.charAt(i + l) < num.charAt(i + j + l)) t = (t + cont[i + j][j]) % 1000000007;
                else if (j < n) t = (t + cont[i + j][j + 1]) % 1000000007;
                cont[i][j] = t;
            }
        }
        return cont[0][1];
    }
}

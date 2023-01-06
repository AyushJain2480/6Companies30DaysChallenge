class Solution {
    public static String longestPrefix(String s) {
        String result = "";
        if (s == null || s.length() == 0) {
            return result;
        }
        int lps[] = computeLPSArray(s);
        int lastIndex = lps[s.length() - 1];
        if (lastIndex == 0) {
            return result;
        } else {
            result = s.substring(0, lastIndex);
        }
        return result;
    }
    
    public static int[] computeLPSArray(String pat) {
        int i = 0;
        int j = i + 1;
        int M = pat.length();
        int lps[] = new int[M];
        lps[0] = 0; // lps[0] is always 0

        // the loop calculates lps[i] for j = 1 to M-1
        while (j < M) {
            if (pat.charAt(i) == pat.charAt(j)) {
                lps[j] = i + 1;
                j++;
                i++;
            } else {
                if (i != 0) {
                    i = lps[i - 1];
                }
                else // if (i == 0)
                {
                    lps[j] = i;
                    j++;
                }
            }
        }
        return lps;
    }
}

class Solution {
    public int magicalString(int n) {
        StringBuilder sb = new StringBuilder().append(122);
        int c = 0;
        for(int i = 2; sb.length() <= n; i++){
            int len = sb.length();
            sb.append((sb.charAt(i) == '1') ? (sb.charAt(len - 1) == '1' ? 2 : 1) : (sb.charAt(len - 1) == '1' ? 22 : 11));
            c += (i < n && sb.charAt(i) == '1') ? 1 : 0;
        }
        return c;
    }
}

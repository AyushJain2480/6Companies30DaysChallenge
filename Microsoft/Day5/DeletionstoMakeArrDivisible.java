int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }
public int minOperations(int[] nums, int[] divs) {
    Arrays.sort(nums);
    int div = Arrays.stream(divs).reduce((a, b) -> gcd(a, b)).getAsInt();
    for (int i = 0; i < nums.length; ++i)
        if (div % nums[i] == 0)
            return i;
    return -1;
}

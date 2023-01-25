class Solution {
    public int[] closestPrimes(int left, int right) {
        int[] nums = {-1, -1};
        int min = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++){
            if (isPrime(i)){
                list.add(i);
            }
        }
        if (list.isEmpty() || list.size() < 2){
            return nums;
        }
        for (int i = 1; i < list.size(); i++){
            int temp = list.get(i) - list.get(i-1);
            if (min > temp){
                min = temp;
                nums[0] = list.get(i-1);
                nums[1] = list.get(i);
            }
        }
        return nums;
    }

    boolean isPrime(int n)
    {
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        return true;
    }
}

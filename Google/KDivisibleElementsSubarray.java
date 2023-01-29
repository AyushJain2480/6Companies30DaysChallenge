class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        
        Set<String> set = new HashSet<>();
        
        for(int i = 0; i < nums.length; i++){
            int count = 0;
            
            for(int j = i; j < nums.length; j++){
                
                 if(nums[j] % p == 0){
                   count++;
                 }
                
                 if(count > k){
                     break;
                 }
                 set.add(Arrays.toString(Arrays.copyOfRange(nums, i, j + 1)));
            }
        }
        return set.size();
    }
}

class Solution {
	public int countDistinct(int[] nums, int k, int p) {
		HashSet<String> hs = new HashSet<>();

		for(int i=0; i<nums.length; ++i) {
			int cnt = 0;
			StringBuilder sb = new StringBuilder();

			for(int j=i; j<nums.length; ++j) {

				if(nums[j] % p == 0) {
					cnt++;
				}
				if(cnt > k) {
					break;
				}
				sb.append(nums[j] + ",");
                
				hs.add(sb.toString());
			}
		}
		return hs.size();
	}

}

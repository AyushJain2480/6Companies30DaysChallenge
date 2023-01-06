 public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int n = nums1.length;
        List<Integer> diffList = new ArrayList<>();
        long res = 0;
        for (int i = 0; i < n; i++) {
            int curDiff = nums1[i] - nums2[i];
            int target  = curDiff + diff; 
            res += countSmallerEqual(diffList, target);
            diffList.add((int) countSmallerEqual(diffList, curDiff), curDiff);
        }
        return res;
    }
    
    private long countSmallerEqual(List<Integer> diffList, int target) {
        int left = 0, right = diffList.size(); 
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (diffList.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (long)left;
    }

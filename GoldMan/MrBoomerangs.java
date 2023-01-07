class Solution {
   public int numberOfBoomerangs(int[][] points) {
		if(points == null || points.length == 0 || points[0].length == 0){
			return 0;
		}
		int count = 0;
		Map<Integer,Integer> map = new HashMap<>();
		for (int i = 0;i < points.length;i++){
			//count distances for every i with an empty hashMap,and hashMap.clear() is more faster than new HashMap()
			map.clear();
			for (int j = 0;j < points.length;j++){
				//it's unnecessary when i == j
				if (i == j){
					continue;
				}
				//multiple them directly is more faster than use Math.pow()
	int distance = (points[j][0]-points[i][0])*(points[j][0]-points[i][0]) + (points[j][1]-points[i][1]) * (points[j][1]-points[i][1]);
				//First, select one position to place your new point by distance with number of hashMap.get(distance)
				//and then you can change the order of the two elements,so multiple 2
                if(map.containsKey(distance)){
                    count += map.get(distance) * 2;
                    map.put(distance , map.get(distance) + 1);
                }else{
                    map.put(distance, 1);
                }
				// count += hashMap.getOrDefault(distance,0) * 2;
				// hashMap.put(distance,hashMap.getOrDefault(distance,0) + 1);
			}
		}
		return count;
	}
}

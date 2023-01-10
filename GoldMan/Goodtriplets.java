 // This is brute force approach using three nested for loops we can optimise it using Fenwick tree or binary index tree  
Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums2.length; i++){
            map.put(nums2[i],i);
        }
        int count = 0;
        for(int i = 0; i < nums1.length - 2; i++){
            for(int j = i + 1; j < nums1.length - 1; j++){
                    int posx = map.get(nums1[i]);
                    int posy = map.get(nums1[j]);
                    if(posx > posy) continue;
                for(int k = j + 1; k < nums1.length; k++){
                    int posz = map.get(nums1[k]);
                    if(posy > posz) continue;
                    else count++;
                }
            }
        }
        return count;

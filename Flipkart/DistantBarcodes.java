class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {

        Map<Integer,Integer> map = new HashMap<>();
        for(int barcode : barcodes) map.put(barcode , map.getOrDefault(barcode,0) + 1);
        
        // Storing keys only , previously we are storing the object itself
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            return map.get(b) - map.get(a);
        });
        pq.addAll(map.keySet());

        int i = 0;
        while(!pq.isEmpty()){
            Integer ele = pq.poll();
            Integer freq = map.get(ele);
            while(freq-- > 0){
                barcodes[i] = ele;
                i += 2;
                if(i >= barcodes.length) i = 1;
            }
        }
        return barcodes;
    }
}

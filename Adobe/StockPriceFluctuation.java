// Good question for revising priority queue , Hashmap, TreeMap, comparator , minHeap, maxHeap, Collections overall really hard and interesting.

// Approach 1: Using HashMap and TreeMap - time O(n*logn) | space O(n)
class StockPrice {

    private HashMap<Integer, Integer> timestampPriceMap;
    private TreeMap<Integer, Integer> priceFrequencyMap;
    private int lastestTimestamp = Integer.MIN_VALUE;

    public StockPrice() {
        timestampPriceMap = new HashMap<>();
        priceFrequencyMap = new TreeMap<>();
    }

    public void update(int timestamp, int price) {

        if (timestampPriceMap.containsKey(timestamp)) {

            Integer oldPrice = timestampPriceMap.get(timestamp);
            priceFrequencyMap.put(oldPrice, priceFrequencyMap.get(oldPrice) - 1);
            if (priceFrequencyMap.get(oldPrice) == 0) 
                priceFrequencyMap.remove(oldPrice);
        }

        timestampPriceMap.put(timestamp, price);
        priceFrequencyMap.put(price, priceFrequencyMap.getOrDefault(price, 0) + 1);
        lastestTimestamp = Math.max(lastestTimestamp, timestamp);
    }

    public int current() {
        return timestampPriceMap.get(lastestTimestamp);
    }

    public int maximum() {
        return priceFrequencyMap.lastKey();
    }

    public int minimum() {
        return priceFrequencyMap.firstKey();
    }
}

// Approach 2: Using HashMap, Min Heap and Max Heap - time O(n*logn) | space O(n)
class StockPrice {

    private HashMap<Integer, Integer> timestampPriceMap;
    private PriorityQueue<int[]> minHeap;
    private PriorityQueue<int[]> maxHeap;

    private int latestTimestamp = Integer.MIN_VALUE;

    public StockPrice() {
        timestampPriceMap = new HashMap<>();
        minHeap = new PriorityQueue<>((entry1, entry2) -> entry1[1] - entry2[1]);
        maxHeap = new PriorityQueue<>((entry1, entry2) -> entry2[1] - entry1[1]);
    }

    public void update(int timestamp, int price) {

        timestampPriceMap.put(timestamp, price);
        minHeap.add(new int[]{timestamp, price});
        maxHeap.add(new int[]{timestamp, price});

        latestTimestamp = Math.max(latestTimestamp, timestamp);
    }

    public int current() {
        return timestampPriceMap.get(latestTimestamp);
    }

    public int maximum() {

        int[] max = maxHeap.peek();
        while (timestampPriceMap.get(max[0]) != max[1]) {
            maxHeap.poll();
            max = maxHeap.peek();
        }
        return max[1];
    }

    public int minimum() {
        int[] min = minHeap.peek();
        while (timestampPriceMap.get(min[0]) != min[1]) {
            minHeap.poll();
            min = minHeap.peek();
        }
        return min[1];
    }
}


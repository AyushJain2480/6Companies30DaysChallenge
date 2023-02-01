class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 0; i <= K; i++) { 
            int[] temp = Arrays.copyOf(dist, n);
            for (int[] edge: flights) { 
                int u = edge[0] , v = edge[1] ,w = edge[2];
                if (dist[u] == Integer.MAX_VALUE) continue;
                temp[v] = Math.min(dist[u] + w , temp[v]); 
            }
            dist = temp;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
     }
}

// Here is a detailed explanation of each line in the code:

// int[] dist = new int[n]; - This line declares an array "dist" of size n, which is the number of cities in the flight network.

// Arrays.fill(dist, Integer.MAX_VALUE); - This line fills the array "dist" with the maximum value of an integer, which represents
// that initially, the distance from the source city to any other city is unknown.

// dist[src] = 0; - This line sets the distance from the source city to 0.

// for (int i = 0; i <= K; i++){ - This line starts a loop that iterates over K iterations, which represents the maximum number
//   of stops the traveler is allowed to take.

// int[] temp = Arrays.copyOf(dist, n); - This line creates a temporary array "temp" that is a copy of the "dist" array, which
//   represents the distances from the source city to other cities.

// for (int[] edge: flights) { - This line starts another loop that iterates over the "flights" array, which represents the flight
//   connections between cities.

// int u = edge[0] , v = edge[1] ,w = edge[2]; - This line extracts the source city (u), destination city (v), and flight price 
//   (w) from the "edge" array.

// if (dist[u] == Integer.MAX_VALUE) continue; - This line checks if the distance from the source city to city "u" is unknown,
//                            and if it is, the loop continues to the next iteration.

// temp[v] = Math.min(dist[u] + w , temp[v]); - This line updates the distance from the source city to city "v" if the new distance 
//                              is smaller than the previously stored value. This is the "relax" function that is used in the
//                              Bellman-Ford algorithm to update the distances.

// dist = temp; - This line updates the "dist" array with the newly calculated values from the "temp" array.

// return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst]; - This line returns the final result, which is the distance from the 
//   source city to the destination city "dst". If the distance is unknown, the function returns -1.

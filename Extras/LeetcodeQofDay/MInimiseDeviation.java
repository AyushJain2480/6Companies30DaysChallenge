class Solution {
    public int minimumDeviation(int[] nums) {
        // First create a priority Queue
        // and implemented a custom comperator, which help us in making this priority queue act like a max heap
        // concept of max heap states that, highest value should lie at the front of the queue & lowest value at the back of the queue
        // sorted in decreasing order
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b - a));// so we apply the custom comperator over here
        
        int min = Integer.MAX_VALUE;// creating minimum variable
        for(int i : nums){// add these values in priority queue
            if(i%2!= 0) i *= 2;// if value is odd mult. by 2 & make it even
            min = Math.min(min , i); // find the minimum
            pq.add(i);
        }// now we have the value in the priority queue, where we have convert all the odd's into even
        
        int diff = Integer.MAX_VALUE;
        // let's find the maximum of all the value
        while(pq.peek() % 2 == 0){
            int max = pq.poll();// max will be at top of the queue
            diff = Math.min(diff, max - min);// find the difference
            min = Math.min(min , max/2);//minimum can change because, new value we are getting by half max can be lower then current minimum
            pq.add(max/2);// add that in the queue
        }
        // when odd is at the biggest than you cannot further divide it so check the difference between the largest odd and min
        // and compare with the diff i.e minimum because everytime we calculate diff when we find a new max and update our diff it is 
        // minimum than the previous diff but when we reach at the postion where our max is odd the loop will not work but for this
        // last step you compare the prev minmdiff and this odd and min difference which is minimum than you will return it.
        return Math.min(diff , pq.peek() - min);
    }
}


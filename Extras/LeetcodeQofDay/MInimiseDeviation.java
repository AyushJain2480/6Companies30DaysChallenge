// In the given code, the odd values in the input array are first converted to even values by multiplying them by 2. The reason for doing this is that we want to find the minimum possible deviation, which is the difference between the maximum and minimum values in the array, after applying a certain operation to all the values.

// Now, we can only apply the operation of dividing an element by 2, if it is an even number. So, by converting all odd values to even, we are ensuring that we can apply the operation to all the elements in the array.

// Additionally, by converting odd values to even, we are not changing the maximum possible deviation that we can get after applying the operation. This is because, if an odd value is the maximum value in the array, then its even counterpart (after multiplication by 2) will still be the maximum value in the array after applying the operation of dividing by 2. Therefore, the maximum possible deviation remains the same.

// Hence, converting odd values to even makes it easier to find the minimum possible deviation by allowing us to apply the operation of dividing by 2 to all the elements in the array.
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


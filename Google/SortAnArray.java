class Solution {
    public int[] sortArray(int[] nums) {
        sort(nums,  new int[nums.length],  0,  nums.length - 1);
        return nums;
    }
   public void sort(int[] arr, int[] temp, int low , int high){
        if(low < high){ // base case

        int mid = low + (high - low) / 2; // overflow condition(low + high) / 2;

        // we break the array into two parts
        // recursively calling sort method for left and right subarray
        sort(arr, temp, low, mid); // for left part
        sort(arr, temp, mid+1, high); // for right part

       // we are merging two sorted arrays to get a bigger sorted array
        merge(arr, temp, low, mid, high);
    }
    }

    private void merge(int[] arr, int[] temp, int low, int mid, int high) {

        // copying the elements of original array into temporary array
        // from low to mid we have a left subarray which is sorted
        // from mid + 1 to high we have a right subarray which is sorted

        for (int i = low; i <= high ; i++) {
           temp[i] = arr[i];
        }
        int i = low; // traverse left sorted subarray
        int j = mid + 1; // traverse right sorted subarray
        int k = low; // will merge both arrays into original array (arr)

        while(i <= mid && j <= high){
            if(temp[i] < temp[j]){
                arr[k] = temp[i];
                i++;
            }else{
                arr[k] = temp[j];
                j++;
            }
            k++;
        }
        // if the left array is exhausted than we dont need to copy the elements of right array in original array
        // because those elements are already in correct position in the original array.
        // but if right array is exhausted than we are using one logic to copy all the elements of left sub array into the original array

        while(i <= mid){
            arr[k] = temp[i];
            i++;
            k++;
        }
    }
}

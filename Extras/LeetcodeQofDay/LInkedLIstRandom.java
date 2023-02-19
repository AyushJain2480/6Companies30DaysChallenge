class Solution {
    ListNode head;
    Random random = new Random();
    public Solution(ListNode head) {
       this.head = head; 
    }
    ArrayList<Integer> list = new ArrayList<>();
    public int getRandom() {
        if (head == null) {
           throw new IllegalArgumentException("Linked list is empty");
        }
        ListNode temp = head;
        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }
        int randomElement = getRandomElement(list);
        return randomElement;
    }
    
    // generates a random integer between 0 (inclusive) and the size of the ArrayList (exclusive), 
    public int getRandomElement(ArrayList<Integer> list){
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}

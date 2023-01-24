public class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
    	return helper(price, special, needs, 0);
    }
    
    private int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int pos) {
        
    	int local_min = directPurchase(price, needs); // without any offer 
        
        // For example no 1 price = [2,5], special = [[3,0,5],[1,2,10]], needs = [3,2]
        
        // offer1 (if selected first) --> again check offer1 (not valid so not selected)
        //                       |--> check for offer2 (not valid so not selected)
        // means offer1 + newNeeds ka directPurchase (because new needs par valid offer nhi mil raha )
        // at last min of localMin(default needs ka directPurchase) , offer1 + newNeeds ka directPurchase 
        // so the second condition will give 15 which is lower than directpurchase
        
        // offer2 (if selected first) --> again check offer2 (not valid so not selected)
        //                            |--> check for offer1(not valid so not selected)
        // this will return 14 
        
        // atlast 14 and 15 minm is 14
        
        // so if we select the second offer first than it is less costly for us :)
    	for (int i = pos; i < special.size(); i++) {
    		List<Integer> offer = special.get(i);
    		List<Integer> temp = new ArrayList<Integer>(); // if you select any offer needs will be reduced and in temp we store that
        	for (int j= 0; j < needs.size(); j++) {
        		if (needs.get(j) < offer.get(j)) { // check if the current offer is valid
        			temp =  null;
        			break;
        		}
        		temp.add(needs.get(j) - offer.get(j)); // update needs after selecting any offer 
        	}
        	
    		if (temp != null) { // means offer is valid // use the current offer and try next
    			local_min = Math.min(local_min, offer.get(offer.size() - 1) + helper(price, special, temp, i)); 
    		}
    	} // if offer is invalid check another offer 

    	return  local_min;
    }
    
    private int directPurchase(List<Integer> price, List<Integer> needs) {
    	int total = 0;
    	for (int i = 0; i < needs.size(); i++) {
    		total += price.get(i) * needs.get(i);
    	}
    	
    	return total;
    }
}

class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> ans = new ArrayList<>();
        // Har transaction pr check kro ki khi money > 1000 to nhi agar ha matlab invalid ith transaction he
        // agar nhi  to check kro age kisi transaction se match krra ho acc to cond 2 if yes dono transaction ith and jth 
        // invalid krdo 
        int n =  transactions.length;
        String[] name = new String[n];
        int[] time = new int[n];
        int[] money = new int[n];
        String[] city = new String[n];
        Boolean[] invalid = new Boolean[n];

        for(int i = 0; i < n; i++){
            String[] split = transactions[i].split(",");
            name[i] = split[0];
            time[i] = Integer.parseInt(split[1]);
            money[i] = Integer.parseInt(split[2]);
            city[i] = split[3];
        }
        
        for(int i = 0; i < n; i++){
            if(money[i] > 1000){
                invalid[i] = true;
            }
            for(int j = i + 1; j < n; j++){
              if(name[i].equals(name[j]) && !city[i].equals(city[j]) && Math.abs(time[i] - time[j]) <= 60){
                  invalid[i] = true;
                  invalid[j] = true;
              }
            }
           
        }

        for(int i = 0; i < n; i++){
            if(invalid[i] != null){
                ans.add(transactions[i]);
            }
        }
        return ans;
    }
}

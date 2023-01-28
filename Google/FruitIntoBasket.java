class Solution{
public int totalFruit(int[] fruits) {
    if(fruits.length == 0 || fruits == null) return 0;
    if(fruits.length == 2) return 2;
    
    int max = Integer.MIN_VALUE;
    
    int fruit1 = -1;
    int fruit2 = -1;
    
    int fruit2Index = 0;
    int count = 0;
    for(int i = 0; i < fruits.length; i++){
        
        if(fruit1 == -1){
            fruit1 = fruits[i];
            count++;
            continue;
        }
        if(fruits[i] == fruit1){
            count++;
            continue;
        }
        if(fruit2 == -1){
            fruit2 = fruits[i];
            fruit2Index = i; // store the value when entering into 2nd hashmap 
            count++;
            continue;
        }
        if(fruits[i] == fruit2){
            count++;
            continue;
        }
        if(fruits[i] != fruit1 && fruits[i] != fruit2){
            max = Math.max(max , count);
            count = 0;
            i = fruit2Index;
            
            fruit1 = fruits[i];
            count++;
            fruit2 = -1;
        }
    }
         max = Math.max(max,count);
        return max == Integer.MIN_VALUE ? 2 : max;
}
}


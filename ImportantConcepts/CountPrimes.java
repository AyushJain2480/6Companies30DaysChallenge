// seive of eratosthenes
// for till n if n is 37 hume 37 + 1 ki array bnani pdti 
// but in this case 37 tak hi chlana to index 0 to 36 bnege kyuki 37 wala ni check krna 
// upar 0 to 37 bnta kyuki 37 bhi chahiye tha 
// 1] boolean array bnao till n me n + 1 ki least ne me n tak 
// 2] sab jagh true manlo (har no. ko prime manlo)
// 3] in short har no. fir visit kro agar true he means it is prime but uske jo multipliers he unhe false krdo 
// or jo already false he means koi factor he unka jo unhe non prime bnara he to uske multipliers already non prime krdie gy hoge
// to false me skip maro 
// last me count krlo
// par ha square root tak hi chlayge 
// like at i = 2 dp[i] is true means it is prime but uske multipliers nhi hoge to unhe non prime krdo
// 2 bola I m prime but I don't let you live prime 
// smjne ke lie true bharke kro but fast krne k lie t - f manlo f - t starting me bhrne ki mehnat ni lgegi na 
// for div = 2 --> n / 2 times (4,6,8,10)
//     div = 3 --> n / 3 times (6,9...)
//     div = 4 --> 1 times (8,12,...)
//     div = root(n) --> n/root(n) times
// total iterations = n/2 + n/3 + n/5 + ---- n/root(n)
// n(1/2 + 1/3 + 1/5 + --- 1/root(n)) = n(log(log(n))) is the TC of this seive method
// O(n) prime generations
// query - almost O(1) lgega ek bar generate k bad 
class Solution {
   public int countPrimes(int n){
         boolean[] dp = new boolean[n];
         Arrays.fill(dp,true);
         // 0,1 ka koi lena dena ni prime me 2 se start kro 
         // 2 to 36 haha par root tak chalao reason same he unique factors root tak milte he root par bhi ek unique 
         // hota he isley hi vo lete he pehle uske a * b or bad me b * a isley bad ke ni lete 
         for(int div = 2; div * div < n; div++){
             if(dp[div] == true){
                 for(int j = div + div; j < n; j += div){
                     dp[j] = false;
                 }
             }
         }
         int ans = 0;
         for(int i = 2; i < n; i++){
            if(dp[i] == true){
                ans++;
            } 
         }
       return ans;
   }
}


    

     public int countPrimes(int n) {
        if(n == 0 || n == 1) return 0;
        // how many primes are there strictly less than 2 i.e 0 
        if(n == 2) return 0;
        int primeCount = 1;
        // let n = 10
        // i = 0 to 10
        // don't check the last no. 
        for(int i = 3; i < n; i++){ 
            int count = 0;
            // try to divide n and increase count
            // First it will check for 0 if there is any no. that can divide 0 if yes we found the divisor so it is not prime
            // for 9 it will divide 9 by 2 and 3 as (4 < 9 && 9 <= 9) as (9 % 3 == 0)means it is not prime
            for(int div = 2; div * div <= i; div++){ 
                if(i % div == 0){
                    count++;
                    break;
                }
            }
            if(count == 0){
                primeCount++;
            }
        }
        return primeCount;
    }


        // we are finding the total divisors from 1 to n of number n if the count is 2 i.e means it is prime 
        // but if count is not equal to 2 (i.e more than 2 that means it is not prime)
        // because a prime no. can divide by itself and 1 only so there are only 2 possible divisors for prime no.
        // 10^9 [1 sec]
   
        // for 12 we get the count equal to 6 (divided by 1,2,3,4,6,12) so it is not prime
        // t = 10^4 and n = 10^9
        // so upto 10^4 times the outer loop will run and try to take the input with the scanner and for every input 
        // it will take 10^9 times to find weather it is prime or not so for 10^4 times it takes total 
        // 10^4 * 10^9 = 10^13 time complexity so that will give us TLE
        for(int i = 0; i < t; i++){ // - 10^4
            int n = sc.nextInt();
            for(int div = 1; div <= n; div++){ // 10^9 
                if(n % div == 0){
                    count++;
                }
            }
            if(count == 2){
                System.out.println("prime");
            }else{
                System.out.println("non prime");
            }
        }

       // kisi bhi no. ka divide hona he to apne square root tak divide hojayga kisi na kisi se agar square tak divide
       // nhi hua to square root ke bad bhi ni hoga 
       // factors of 36
       // 1 x 36 | 36 x 1
       // 2 x 18 | 18 x 2
       // 3 x 12 | 12 x 3
       // 4 x 9  | 9 x 4
       //      6 x 6
       // p.q = n
       // p > root(n) & q > root(n) ye false he dono root n se bde ni hoskte ya to ek chota hoga ya max dono root n ke equal hoge
       // 1 se n nhi ab 2 se root(n) chlega kisi se bhi divide hogya to non prime else prime 
       // div < root(n) 
       // total 10^9 means around 1 sec that will pass wohooo
       for(int i = 0; i < t; i++){  // - 10^4
           int n = sc.nextInt();
           int count = 0;
           for(int div = 2; div*div <= n; div++){  // root(10^9) i.e around 10^5
               if(n % div == 0){
                   count++;
                   break;
               }
           }
           if(count == 0){
               print("prime");
               else print("non prime");
           }
       }

 // LOl this is also not passing 
 public boolean isPrime(int n){
    if (n <= 1)
        return false;
    if (n <= 3)
        return true;
    if (n % 2 == 0 || n % 3 == 0)
        return false;
    for (int i = 5; i * i <= n; i = i + 6)
        if (n % i == 0 || n % (i + 2) == 0)
            return false;
    return true;
   }

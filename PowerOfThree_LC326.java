class Solution {
    public boolean isPowerOfThree(int n) {
     if(n==1)return true; // something to power 0 is 1 so 3 to power 0 is 1
     if(n%3!=0|| n<=0)return false;
       while(n%3==0){
         n=n/3;
       }
       return n==1;
    }
}
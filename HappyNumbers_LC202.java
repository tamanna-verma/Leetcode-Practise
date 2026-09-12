class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
 
        while(true){          
           int sum = 0;
            while(n>0){
                int remainder = n%10;
                n= n/10;
                sum+=(remainder * remainder);
            }
            if(set.contains(sum))return false;
            else if(sum==1)return true;
            set.add(sum);
            n=sum;
           if(n==0)break;
        }
        return true;   
    }
}
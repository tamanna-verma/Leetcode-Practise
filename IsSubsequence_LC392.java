class Solution {
       public boolean isSubsequence(String s, String t) {
        HashMap<Character , ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<t.length();i++){
            Character c = t.charAt(i);
            ArrayList<Integer> list = map.getOrDefault(c,new ArrayList<Integer>());
            list.add(i);
            map.put(c,list);
        }
         int prev = -1;
        for(int i=0;i<s.length();i++){
         Character c = s.charAt(i);
         ArrayList<Integer> list = map.getOrDefault(c,new ArrayList<Integer>());
         if(list.size()==0)return false;
         int nextIndex = getNextIndex(0,list.size()-1,list,prev);
         if(nextIndex==-1)return false;
         prev=nextIndex;
        }
        return true;
       }
       public int getNextIndex (int left , int right , ArrayList<Integer> list, int previous){
        int ans = -1;
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(list.get(mid)<=previous)left=mid+1;
            else if(list.get(mid)>previous)
            {
              right = mid-1;
              ans = list.get(mid);
            }
        }
        return ans;
       }


    // // Approach 1 - withhout followup
    // public boolean isSubsequence(String s, String t) {
    //     int i=0,j=0;
    //     while(i<s.length() && j<t.length()){
    //         if(s.charAt(i)==t.charAt(j)){
    //             i++;j++;
    //         }
    //         else j++;
    //     }
    //    return i==s.length() ? true:false;
    // }
}
// approach 1- jabtak i se j match ni hota j ko bdate jao , jaise hi match ho dono ko bdado , if i has reached end return true else return false
// approach 2 , hume t k sare char ka index map of char and arraylist me store krliya 
// now s ka next character t me dhundna hai, find the index of next character of s in t , and that index should be greater than index of prev character of s found in t , we find that index using binary search


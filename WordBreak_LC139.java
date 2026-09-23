class Solution {
    public int dp [];
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new int [s.length()];
        Arrays.fill(dp,-1);
        return helper(s,0,wordDict);
    }
    public boolean helper(String temp , int index , List<String> wordDict){
        if(index==temp.length())return true;
        if(dp[index]==0) return false;

        StringBuilder str = new StringBuilder();
        for(int i=index;i<temp.length();i++){
            if(wordDict.contains(str.append(temp.charAt(i)).toString()))
            {
                if(helper(temp,i+1,wordDict))return true;
            }
        }
        dp[index]=0;
        return false;
    }
}

// appraoch - ith index se sb start kro , sb me har char add krte jao 
// check kro ki kya ye string hai wordDict me , agar hai to next recursion me i+1th index se start kro 
// agar index 0 phoch jaye mtlb sare substring miilgye hai wordDict me 
// ith index se aage ka answer dp me store krate rho 
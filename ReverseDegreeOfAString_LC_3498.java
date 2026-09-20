class Solution {
    public int reverseDegree(String s) {
        
        int ans = 0;
        for(int i=0;i<s.length();i++){
            int char_num = (s.charAt(i)-'a');
            int mul = Math.abs(char_num-26) ;
            ans += ((i+1)*mul);
           // System.out.println(char_num+" "+mul+" "+ans);
        }
        return ans;
    }
}
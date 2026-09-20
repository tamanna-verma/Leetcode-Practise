class Solution {
    int dp[];

    public int numDecodings(String s) {
        this.dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        int ans = helper(s, 0);
        return Math.max(dp[0], 0);
    }

    public int helper(String s, int i) {
        if (i >= s.length())
            return 1;
        if (dp[i] != -1)
            return dp[i];
        dp[i] = 0;
        if (s.charAt(i) != '0')
            dp[i] = helper(s, i + 1);
        if (i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7')))
            dp[i] += helper(s, i + 2);

        return dp[i];
    }
}
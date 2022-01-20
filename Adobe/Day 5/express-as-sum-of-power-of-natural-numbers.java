Problem Link : https://practice.geeksforgeeks.org/problems/express-as-sum-of-power-of-natural-numbers5647/1#

class Solution
{
    static int numOfWays(int n, int x)
    {
        int dp[]=new int[n+1];
        int mod=(int)(1e9+7);
        dp[0]=1;
        dp[1]=1;
        int max=(int)Math.pow(n,1.0/x);
        for(int i = 2; i <= max; i++){
            int curr = (int)Math.pow(i, x);
            for(int j = n; j >= curr; j--){
                dp[j] = ((dp[j]%mod)+(dp[j-curr]%mod))%mod;
            }
        }
        return dp[n];
    }
}
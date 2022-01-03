Problem Link : https://practice.geeksforgeeks.org/problems/total-decoding-messages1235/1/#

class Solution
{
    static int fun(String str,int n,int dp[]){
        int mod=(int)1e9+7;
        if(n==0 || n==1) return 1;

	if(dp[n]!=-1) return dp[n]; 
        int count=0;
        if(str.charAt(n-1)>'0'){
            count=((count%mod)+(fun(str,n-1,dp)%mod))%mod;
        }
        if(str.charAt(n-2)=='1' || ((str.charAt(n-2)=='2' && str.charAt(n-1)<'7'))) {
	    count=((count%mod)+(fun(str,n-2,dp)%mod))%mod;
	}
	return dp[n]=count%mod;
    }
    
    public int CountWays(String str)
    {
        int n=str.length();
        int dp[]=new int[n+1];
	Arrays.fill(dp,-1);
        if(str.charAt(0)=='0') return 0;
        return fun(str,n,dp);
    }
}
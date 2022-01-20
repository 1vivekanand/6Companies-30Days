Problem Link : https://practice.geeksforgeeks.org/problems/pots-of-gold-game/1/#

class GfG
{
    
   static  int fun(int a[],int i,int j,Integer dp[][]){
        if(i>j ) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        int first=a[i]+Math.min(fun(a,i+2,j,dp),fun(a,i+1,j-1,dp));
        int last=a[j]+Math.min(fun(a,i,j-2,dp),fun(a,i+1,j-1,dp));
        return dp[i][j]=Math.max(first,last);
    }
    
	public static int maxCoins(int a[],int n)
	{
	 Integer dp[][]=new Integer[n][n];
         return fun(a,0,n-1,dp);
    }
}
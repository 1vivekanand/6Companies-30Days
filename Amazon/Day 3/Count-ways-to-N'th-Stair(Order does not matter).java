Problem Link : https://practice.geeksforgeeks.org/problems/count-ways-to-nth-stairorder-does-not-matter1322/1/#

Approach 1: O(n)

class Solution
{
    Long countWays(int m)
    {
        long dp[]=new long[m+1];
        dp[0]=1;
        for(int i=1;i<=m;i++){
            if(i==1){
                dp[i]=1;
            }
            else{
                dp[i]=dp[i-2]+1;
            }
        }
        return dp[m];
    }    
}


Approach 2: O(1) -> you can observe from the count array that it is increasing by 1 at even positions

class Solution
{
    Long countWays(int m)
    {
        return (long)m/2+1;
    }    
}
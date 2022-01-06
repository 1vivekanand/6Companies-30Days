Problem Link : https://practice.geeksforgeeks.org/problems/maximum-profit4657/1#

class Solution {
    static int maxProfit(int k, int n, int a[]) {
        
        int dp[][]=new int[k+1][n+1];
        for(int i=1;i<=k;i++){
            int max=Integer.MIN_VALUE;
            for(int j=1;j<a.length;j++){
                if(dp[i-1][j-1]-a[j-1]>max){
                    max=dp[i-1][j-1]-a[j-1];
                }
                if(max+a[j]>dp[i][j-1]){
                    dp[i][j]=max+a[j];
                }
                else{
                    dp[i][j]=dp[i][j-1];    
                }
            }
        }
        return dp[k][n-1];
    }
}
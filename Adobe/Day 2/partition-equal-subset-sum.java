Problem Link : https://leetcode.com/problems/partition-equal-subset-sum/

Approach 1: 2D DP
class Solution {    
    
    public boolean canPartition(int[] nums) {
        int sum=0,n=nums.length;
        for(int x:nums){
            sum+=x;
        }        
        if(sum%2!=0) return false;
        sum/=2;
        boolean dp[][]=new boolean[n+1][sum+1];
        for(int i=0;i<sum+1;i++){
            dp[0][i]=false;
        }
        for(int i=0;i<n+1;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(nums[i-1]<=j){
                    dp[i][j]=dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
                else dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][sum];
    }
}

Approach 2: 1D DP
class Solution {    
    
    boolean fun(int idx,int sum,int nums[],Boolean dp[]){
        if(sum<0) return false;
        if(idx>=nums.length) return sum==0;
        if(dp[sum]!=null) return dp[sum];
        return dp[sum]=fun(idx+1,sum-nums[idx],nums,dp) || fun(idx+1,sum,nums,dp);
    }
    
    public boolean canPartition(int[] nums) {
        int sum=0,n=nums.length;
        for(int x:nums){
            sum+=x;
        }        
        if(sum%2!=0) return false;
        sum/=2;
        Boolean dp[]=new Boolean[sum+1];
        return fun(0,sum,nums,dp);
    }
}
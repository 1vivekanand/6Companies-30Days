Problem Link : https://leetcode.com/problems/longest-arithmetic-subsequence/

class Solution {
    public int longestArithSeqLength(int[] nums) {
        int ans=2,n=nums.length;
        HashMap<Integer,Integer>[] dp=new HashMap[n];
        for(int i=0;i<n;i++){
            dp[i]=new HashMap<>();
            for(int j=0;j<i;j++){
                int dif=nums[i]-nums[j];
                dp[i].put(dif,dp[j].getOrDefault(dif,1)+1);
                ans=Math.max(ans,dp[i].get(dif));
            }
            System.out.println();
        }
        return ans;
    }
}
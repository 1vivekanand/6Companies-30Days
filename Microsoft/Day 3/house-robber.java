Problem Link : https://leetcode.com/problems/house-robber/

class Solution {
    public int rob(int[] nums) {

	// msi -> maximum sum including this
	// mse -> maximum sum excluding this
        int msi=nums[0],mse=0,msip=nums[0];
        for(int i=1;i<nums.length;i++){
            msi=mse+nums[i];
            mse=Math.max(mse,msip);
            msip=msi;
        }
        return Math.max(mse,msi);
        
    }
}
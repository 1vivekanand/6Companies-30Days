Problem Link : https://leetcode.com/problems/minimum-size-subarray-sum/

public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int l=0,r=0;
        if(nums[l]==target) return 1;
        int sum=nums[r],ans=Integer.MAX_VALUE;
        while(r<n && l<n){
            if(sum==target){
                ans=Math.min(ans,r-l+1);
                if(l<n) sum-=nums[l];
                l++;
            }
            else if(sum<target){
                r++;
                if(r<n)sum+=nums[r];
            }
            else {
                ans=Math.min(ans,r-l+1);
                if(l<n) sum-=nums[l];
                l++;
            }
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }
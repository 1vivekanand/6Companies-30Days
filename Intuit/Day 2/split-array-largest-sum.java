Problem Link : https://leetcode.com/problems/split-array-largest-sum/

class Solution {
    
    boolean canPartition(int[] nums,int mid,int m){
        int req=1,sum=0;
        for(int x:nums){
            sum+=x;
            if(sum>mid){
                sum=x;
                req++;
                if(req>m) return false;
            }
        }
        return true;
    }
    
    public int splitArray(int[] nums, int m) {
        int max=Integer.MIN_VALUE,sum=0;
        for(int x:nums){
            max=Math.max(max,x);
            sum+=x;
        }
        int l=max,r=sum;
        while(l<r){
            int mid=l+(r-l)/2;
            if(canPartition(nums,mid,m)==true){
                r=mid-1;
            }
            else l=mid+1;
        }
        return l;
    }
}
Problem Link : https://practice.geeksforgeeks.org/problems/count-the-subarrays-having-product-less-than-k1708/1/#

class Solution {
    
    public int countSubArrayProductLessThanK(long nums[], long n, long k)
    {
        if(k<=1) return 0;
        int left=0;
        int ans=0;
        long product=1l;
        for(int right=0;right<n;right++){
            product*=nums[right];
            while(product>=k){
                product/=nums[left];
                left++;
            }
            ans+=right-left+1;
        }
       return ans;
    }
}
Problem Link : https://leetcode.com/problems/koko-eating-bananas/

class Solution {
    
    public int minEatingSpeed(int[] piles, int h) {
        
        int l=1,r=1000000001,n=piles.length;
        while(l<=r){
            int mid=l+(r-l)/2;
            int hour=0;
            for(int i=0;i<n;i++){
                hour+=Math.ceil(1.0*piles[i]/mid);
            }
            if(hour>h){
                l=mid+1;
            }
            else r=mid-1;
        }
        return l;
    }
}
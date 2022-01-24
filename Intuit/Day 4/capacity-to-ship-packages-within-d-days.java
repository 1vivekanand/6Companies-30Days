Problem Link : https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

class Solution {
    
    boolean canShip(int[] weights,int mid,int d){
        int sum=0,dr=1;
        for(int i=0;i<weights.length;i++){
            sum+=weights[i];
            if(weights[i]>mid) return false;
            if(sum>mid){
                dr++;
                sum=weights[i];
                if(dr>d){
                    return false;
                }
            }
        }
        return true;
    }
    
    public int shipWithinDays(int[] weights, int days) {
        int min=Integer.MAX_VALUE,sum=0;
        for(int x:weights){
            
            sum+=x;
            min=Math.min(min,x);
        }
        int l=min,r=sum,n=weights.length;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(canShip(weights,mid,days)==true){
                r=mid-1;
            }
            else l=mid+1;
        }
        return l;
    }
}
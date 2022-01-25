Problem Link : https://leetcode.com/problems/find-in-mountain-array/

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int l=0,n=mountainArr.length();
        int r=n-1,ans=0;
        while(l<r){
            int mid=l+(r-l)/2;
            if(mountainArr.get(mid)<mountainArr.get(mid+1)) {
                l=ans=mid+1;
            }
            else r=mid;
        }
        
        r=ans;
        l=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            int ele=mountainArr.get(mid);
            if(ele==target) {
                return mid;
            }
            else if(ele<target){
                l=mid+1;
            }
            else r=mid-1;
        }
        
        l=ans;
        r=n-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            int ele=mountainArr.get(mid);
            if(ele==target) {
                return mid;
            }
            else if(ele>target){
                l=mid+1;
            }
            else r=mid-1;
        }
        
        
        
        return -1;
    }
}
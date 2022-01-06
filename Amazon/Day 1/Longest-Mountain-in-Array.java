Problem Link : https://leetcode.com/problems/longest-mountain-in-array/

class Solution {
    public int longestMountain(int[] arr) {
        int n=arr.length,ans=0,i=1;
        if(n<3) return 0;
        int inc=0,dec=0;
        while(i<n){
            inc=0;
            dec=0;
            while(i<n && arr[i-1]==arr[i]){
                i++;
            }
            while(i<n && arr[i-1]<arr[i]){
                inc++;
                i++;
            }
            while(i<n && arr[i-1]>arr[i]){
                dec++;
                i++;
            }
            if(inc>0 && dec>0){
                ans=Math.max(ans,dec+inc+1);
            }
        }
        return ans;
    }
}
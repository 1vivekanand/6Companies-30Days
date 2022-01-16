Problem Link : https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1#

class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        ArrayList<Integer> ans=new ArrayList<>();
        int l=0,r=1,sum=arr[0];
        while(r<n){
            while(sum<s && r<n){
                sum+=arr[r];
                r++;
            }
            while(sum>s && l<r  && l<n){
                sum-=arr[l];
                l++;
            }
            if(sum==s){
                ans.add(l+1);
                ans.add(r);
                return ans;
            }
        }
        if(sum!=s)ans.add(-1);
        else {
            ans.add(1);
            ans.add(1);
            
        }
        return ans;
    }
}
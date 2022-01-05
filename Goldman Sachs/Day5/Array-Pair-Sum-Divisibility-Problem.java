Problem link : https://practice.geeksforgeeks.org/problems/array-pair-sum-divisibility-problem3257/1#

class Solution {
    public boolean canPair(int[] arr, int k) {
        int rem[]=new int[k];
        int n=arr.length;
        for(int i=0;i<n;i++){
            int val=((arr[i]%k)+k)%k;
            rem[val]++;
        }
        if((rem[0]%2)!=0) return false;
        for(int i=1;i<=k/2;i++){
            if(rem[i]!=rem[k-i]){
                return false;
            }
        }
        return true;
    }
}
Problem Link : https://practice.geeksforgeeks.org/problems/find-all-four-sum-numbers1732/1#

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        Arrays.sort(arr);
        int n=arr.length;
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n-3;i++){
            if(i!=0 && arr[i]==arr[i-1]) continue;
            for(int j=i+1;j<n-2;j++){
                if(j!=(i+1) && arr[j]==arr[j-1]) continue;
                int l=j+1,r=n-1;
                int sum=k-arr[i]-arr[j];
                while(l<r){
                    if(arr[l]+arr[r]==sum){
                        ArrayList<Integer> al=new ArrayList<>();
                        al.add(arr[i]);
                        al.add(arr[j]);
                        al.add(arr[l]);
                        al.add(arr[r]);
                        ans.add(new ArrayList<>(al));
                        while(l<r && arr[l]==arr[l+1]) l++;
                        while(l<r && arr[r]==arr[r-1]) r--;
                        l++;
                        r--;
                    }
                    else if(arr[l]+arr[r]>sum){
                        r--;
                    }
                    else l++;
                }
            }
        }
        return ans;
    }
}
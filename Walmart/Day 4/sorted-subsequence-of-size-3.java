Problem Link : https://practice.geeksforgeeks.org/problems/sorted-subsequence-of-size-3/1/#

Approach 1: 
class Solution {
    ArrayList<Integer> find3Numbers(ArrayList<Integer> arr, int n) {
        int left[]=new int[n];
        int right[]=new int[n];
        left[0]=arr.get(0);
        right[n-1]=arr.get(n-1);
        for(int i=1;i<n;i++){
            left[i]=Math.min(left[i-1],arr.get(i));
        }
        for(int i=n-2;i>=0;i--){
            right[i]=Math.max(right[i+1],arr.get(i));
        }
        ArrayList<Integer> al=new ArrayList<>();
        for(int i=1;i<n-1;i++){
            if(left[i-1]<arr.get(i) && arr.get(i)<right[i+1]){
                al.add(left[i-1]);
                al.add(arr.get(i));
                al.add(right[i+1]);
                break;
            }
        }
        return al;
    }
}

Approach 2 :
// from leetcode

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n=nums.length;
        int c1=Integer.MAX_VALUE,c2=Integer.MAX_VALUE;
        for(int x:nums){
            if(x<=c1){
                c1=x;
            }
            else if(x<=c2){
                c2=x;
            }
            else return true;
        }
        return false;
    }
}
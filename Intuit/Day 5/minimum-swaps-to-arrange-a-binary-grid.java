Problem Link : https://leetcode.com/problems/minimum-swaps-to-arrange-a-binary-grid/

class Solution {
    public int minSwaps(int[][] grid) {
        int n=grid.length;
        int count[]=new int[n];
        for(int i=0;i<n;i++){
            int c=0;
            for(int j=n-1;j>=0;j--){
                if(grid[i][j]==0) c++;
                else {
                    count[i]=c;
                    break;
                }
                
            }
            count[i]=c;
        }
        int ans=0;
        int req=n-1;
        for(int i=0;i<n;i++){            
            int j=i,idx=-1;
            for(;j<n;j++){
                if(count[j]>=req){
                    idx=j;
                    req--;
                    break;
                }
            }
            if(req==-1) break;
            if(idx==-1) return -1;
            
            for(int k=idx-1;k>=i;k--){
                int temp=count[k];
                count[k]=count[idx];
                count[idx]=temp;
                ans++;
                idx--;
            }
        }
        return ans;
    }
}
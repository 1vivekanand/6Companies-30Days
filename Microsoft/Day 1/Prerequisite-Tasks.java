Problem Link : https://practice.geeksforgeeks.org/problems/prerequisite-tasks/1/#

class Solution {
    public boolean isPossible(int n, int[][] arr)
    {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<arr.length;i++){
            adj.get(arr[i][1]).add(arr[i][0]);
        }
        Queue<Integer> q=new LinkedList<>();
        int indg[]=new int[n];
        for(int i=0;i<n;i++){
            for(int x:adj.get(i)){
                indg[x]++;
            }
        }
        for(int i=0;i<n;i++){
            if(indg[i]==0) q.add(i);
        }
        int count=0;
        while(!q.isEmpty()){
            int cur=q.poll();
            count++;
            for(int x:adj.get(cur)){
                if(--indg[x]==0){
                    q.add(x);
                }
            }
        }
        return count==n;
    }
    
}
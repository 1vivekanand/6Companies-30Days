Problem Link : https://leetcode.com/problems/number-of-boomerangs/

class Solution {
    
    int dis(int a[],int b[]){
        int x= (a[0]-b[0]);
        int y=(a[1]-b[1]);
        return x*x+y*y;
    }
    
    public int numberOfBoomerangs(int[][] points) {
        int n=points.length;
        if(n==1) return 0;        
        int ans=0;
        for(int i=0;i<n;i++){
            Map<Integer,Integer> hm=new HashMap<>();
            for(int j=0;j<n;j++){
                if(i==j) continue;
                int dis=dis(points[i],points[j]);
                hm.put(dis,hm.getOrDefault(dis,0)+1);
            }
            for(int val:hm.values()){
                ans+=(val*(val-1));
            }
        }
        return ans;
    }
}
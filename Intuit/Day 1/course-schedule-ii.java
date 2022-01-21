Problem Link : https://leetcode.com/problems/course-schedule-ii/

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       
        ArrayList<ArrayList<Integer>> al=new  ArrayList<ArrayList<Integer>>();
        for(int i=0;i<numCourses;i++){
            al.add(new ArrayList<Integer>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int x=prerequisites[i][0];
            int y=prerequisites[i][1];
            al.get(y).add(x);
        }
        int indg[]=new int[numCourses];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            for(int x:al.get(i)){
                indg[x]++;
            }
        }
        for(int i=0;i<numCourses;i++){
            if(indg[i]==0){
                q.add(i);
            }
        }
        int res[]=new int[numCourses];
        int count=0;
        int k=0;
        while(!q.isEmpty()){
            int x=q.poll();
            res[k++]=x;
            count++;
            for(int a:al.get(x)){
                if(--indg[a]==0){
                    q.add(a);
                }
            }
        }
        return count==numCourses?res:new int[]{};
    }
}
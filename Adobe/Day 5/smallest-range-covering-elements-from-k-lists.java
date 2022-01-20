Problem Link : https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/

class Solution {
    
    class triplet{
        int num;
        int arrpos;
        int numpos;
        
        triplet(int num,int arrpos, int numpos){
            this.num=num;
            this.arrpos=arrpos;
            this.numpos=numpos;
        }
    }
    
    public int[] smallestRange(List<List<Integer>> nums) {
        int minRange=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        int minans=Integer.MAX_VALUE,maxans=Integer.MIN_VALUE;
        int k=nums.size();
        
        Queue<triplet> pq=new PriorityQueue<>((a,b) -> (a.num-b.num));
        for(int i=0;i<k;i++){
            pq.add(new triplet(nums.get(i).get(0),i,0));
            max=Math.max(max,nums.get(i).get(0));
        }
        while(pq.size()==k){
            triplet t=pq.poll();
            int curRange=max-t.num;
            if(curRange<minRange){
                minRange=curRange;
                minans=t.num;
                maxans=max;
            }
            if(t.numpos+1<nums.get(t.arrpos).size()){
                pq.add(new triplet(nums.get(t.arrpos).get(t.numpos+1),t.arrpos,t.numpos+1));
                max=Math.max(max,nums.get(t.arrpos).get(t.numpos+1));
            }
            else return new int[]{minans,maxans};
        }
        return new int[]{minans,maxans};
    }
}
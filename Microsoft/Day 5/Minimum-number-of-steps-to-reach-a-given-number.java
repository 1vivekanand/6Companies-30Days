Problem Link : https://practice.geeksforgeeks.org/problems/minimum-number-of-steps-to-reach-a-given-number5234/1/#

class Solution{    
    
    static int fun(int s,int d,int step){
        if(Math.abs(s)>d) return Integer.MAX_VALUE;
        if(s==d) return step;
        return Math.min(fun(s+step+1,d,step+1),fun(s-step-1,d,step+1));
    }
    
    static int minSteps(int D){
        return fun(0,D,0);
    }
}
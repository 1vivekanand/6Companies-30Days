Problem Link : https://practice.geeksforgeeks.org/problems/ugly-numbers2254/1/#

class Solution {
    /* Function to get the nth ugly number*/
    long getNthUglyNo(int n) {
        
        TreeSet<Long> set=new TreeSet<>();
        set.add(1l);
        for(int i=0;i<n-1;i++){
            long val=set.pollFirst();
            set.add(val*2);
            set.add(val*3);
            set.add(val*5);
        }
        return set.pollFirst();
    }
}
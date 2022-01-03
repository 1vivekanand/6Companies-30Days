Problem Link : https://practice.geeksforgeeks.org/problems/find-the-position-of-m-th-item1723/1#

class Solution {
    static int findPosition(int n , int m , int k) {
        if(n==1) return 1;
        return (k+(m%n)-1)==n?(k+(m%n)-1):(k+(m%n)-1)%n;
    }
}
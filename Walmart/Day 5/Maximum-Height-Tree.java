Problem Link : https://practice.geeksforgeeks.org/problems/maximum-height-tree4803/1/?page=2&company[]=Walmart&query=page2company[]Walmart

class Solution{
    static int height(int X){
         return (-1 + (int)Math.sqrt(1 + 8*X)) / 2;
    }
}
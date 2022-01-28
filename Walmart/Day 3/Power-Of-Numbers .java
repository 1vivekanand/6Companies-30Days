Problem Link : https://practice.geeksforgeeks.org/problems/power-of-numbers-1587115620/1/?company[]=Walmart&company[]=Walmart&page=1&query=company[]Walmartpage1company[]Walmart

class Solution
{
        
    long power(int n,int r)
    {
        if(r==0) return 1;
        if(r==1) return n;
        long mod=(int)(1e9+7);
        long ans=power(n,r/2);
        long ans2= ((ans%mod)*(ans%mod))%mod;
        if(r%2==0){
            return ans2;
        }
        else return ((n%mod)*(ans2%mod))%mod;
    }

}
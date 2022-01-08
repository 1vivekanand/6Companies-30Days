Problem Link : https://practice.geeksforgeeks.org/problems/column-name-from-a-given-column-number4244/1/#

class Solution
{
    String colName (long n)
    {
        StringBuilder sb=new StringBuilder();
        while(n>0){
            n--;
            sb.append((char)(n%26+'a'));
            n/=26;
        }
        return sb.reverse().toString().toUpperCase();
    }
}
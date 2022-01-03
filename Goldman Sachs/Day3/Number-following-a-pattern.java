Problem Link : https://practice.geeksforgeeks.org/problems/number-following-a-pattern3126/1#

class Solution{
    static String printMinNumberForPattern(String s){
        StringBuilder sb=new StringBuilder();
        int countd=0,cur=1,n=s.length();
        for(int i=0;i<n;){
            if(s.charAt(i)=='I' && i==0){
                sb.append(cur);
                cur++;
            }
            if(s.charAt(i)=='D'){
                countd++;
            }
            int j=i+1;
            while(j<n && s.charAt(j)=='D'){
                j++;
                countd++;
            }
            int temp=countd;
            while(countd>=0){
                sb.append(cur+countd);
                countd--;
            }
            cur+=temp+1;
            countd=0;
            i=j;
        }
        return sb.toString();
    }
}

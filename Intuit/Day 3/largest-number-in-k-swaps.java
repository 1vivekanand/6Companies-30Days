Problem Link : https://practice.geeksforgeeks.org/problems/largest-number-in-k-swaps-1587115620/1

class ans{
       static  String max="";
    }
    
class Solution
{
    
    static void fun(char arr[], int k, ans a){
        if(k==0) return ;
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]<arr[j]){
                    char t=arr[i];
                    arr[i]=arr[j];
                    arr[j]=t;
                    String s=new String(arr);
                    if(a.max.compareTo(s)<0){
                        a.max=s;
                    }
                    fun(arr,k-1,a);
                    char y=arr[i];
                    arr[i]=arr[j];
                    arr[j]=y;
                }
            }
        }
    }
    
    public static String findMaximumNum(String str, int k)
        {
            char arr[]=str.toCharArray();
            ans a=new ans();
            a.max=str;
            fun(arr,k,a);
            return a.max;
        }
}
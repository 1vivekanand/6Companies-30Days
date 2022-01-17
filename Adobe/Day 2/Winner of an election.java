Problem Link : https://practice.geeksforgeeks.org/problems/winner-of-an-election-where-votes-are-represented-as-candidate-names-1587115621/1/#

class Solution
{
    //Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n)
    {
        Map<String,Integer> hm=new HashMap<>();
        int max=0;
        for(int i=0;i<n;i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
            max=Math.max(max,hm.get(arr[i]));
        }
        
        String ans="z";
        for(Map.Entry<String,Integer> x:hm.entrySet()){
            if(x.getValue()==max){
                if(x.getKey().compareTo(ans)<0){
                    ans=x.getKey();
                }
            }
        }
        return new String[]{ans,String.valueOf((max))};
    }
}

Problem Link : https://practice.geeksforgeeks.org/problems/stock-span-problem-1587115621/1

class Solution{
    
    // Function to calculate span
    // price[]: input array
    public static int[] calculateSpan(int price[], int n)
    {
        int res[]=new int[n];
        Stack<Integer> st=new Stack<>();
        res[0]=1;
        st.push(0);
        for(int i=1;i<n;i++){
            while(!st.isEmpty() && price[i]>=price[st.peek()]){
                st.pop();
            }
            res[i]=st.isEmpty()?i+1:i-st.peek();
            st.push(i);
        }
        return res;
    }
    
}
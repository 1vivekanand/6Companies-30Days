Problem Link : https://practice.geeksforgeeks.org/problems/deee0e8cf9910e7219f663c18d6d640ea0b87f87/1/#

Approach 1 : (TLE)

class Solution {
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        
        ArrayList<Integer> ans=new ArrayList<Integer>();
        Queue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }
        int l=0,r=k;
        while(r<n){
            int cur=pq.peek();
            ans.add(cur);
            pq.remove(arr[l]);
            pq.add(arr[r]);
            r++;
            l++;
        }
        ans.add(pq.poll());
        return ans;
    }
}

Approach 2 : (AC)

class Solution {
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        
        ArrayList<Integer> ans=new ArrayList<Integer>();
        Deque<Integer> dq=new LinkedList<>();
        for(int i=0;i<k;i++){
            while(!dq.isEmpty() && arr[dq.peekLast()]<=arr[i]){
                dq.removeLast();
            }
            dq.addLast(i);
        }
        for(int i=k;i<n;i++){
            ans.add(arr[dq.peekFirst()]);
            while(!dq.isEmpty() && dq.peek()<=i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && arr[dq.peekLast()]<=arr[i]){
                dq.removeLast();
            }
            dq.addLast(i);
        }
        ans.add(arr[dq.pollFirst()]);
        return ans;
    }
}

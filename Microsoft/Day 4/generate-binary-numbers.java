Problem Link : https://practice.geeksforgeeks.org/problems/generate-binary-numbers-1587115620/1/#

class solve{
    
    //Function to generate binary numbers from 1 to N using a queue.
    static ArrayList<String> generate(int n)
    {        
        ArrayList<String>al=new ArrayList<String>();
        Queue<String> q=new LinkedList<String>();
        q.add("1");
        for(int i=0;i<n;i++){
            String x=q.poll();
            al.add(x);
            q.add(x+"0");
            q.add(x+"1");
        }
        return al;
    }
    
}

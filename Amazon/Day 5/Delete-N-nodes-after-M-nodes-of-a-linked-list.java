Problem Link : https://practice.geeksforgeeks.org/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/1/#

class Solution
{
   static void linkdelete(Node head, int M, int N)
   {
       int n=1,m=N;
       Node cur=head;
       while(cur!=null){
           if(n==M){
               Node p=cur;
               while(p!=null&&m-->0){
                   p=p.next;
               }
               if(p!=null)
               cur.next=p.next;
               else cur.next=p;
               n=0;
               m=N;
           }
           n++;
           cur=cur.next;
       }
   }
}
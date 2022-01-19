Problem Link : https://practice.geeksforgeeks.org/problems/find-smallest-range-containing-elements-from-k-lists/1/#

Approach 1: TLE

class Solution
{
	static int[] findSmallestRange(int[][] arr,int n,int k)
	{
	    
	    int ptr[]=new int[k];
	    Arrays.fill(ptr,0);
	    int i,minval,maxval,omin=0,omax=0,minrange,f,minidx;
	    minrange=Integer.MAX_VALUE;
	    while(true){
	        minidx=-1;
	        minval=Integer.MAX_VALUE;
	        maxval=Integer.MIN_VALUE;
	        f=0;
	        for(i=0;i<k;i++){
	            if(ptr[i]==n){
	                f=1;
	                break;
	            }
	            if(ptr[i]<n && arr[i][ptr[i]]<minval){
	                minval=arr[i][ptr[i]];
	                minidx=i;
	            }
	            if(ptr[i]<n && arr[i][ptr[i]]>maxval){
	                maxval=arr[i][ptr[i]];
	            }
	        }
	        if(f==1){
	            return new int[]{omin,omax};
	        }
	        ptr[minidx]++;
	        
	        if((maxval-minval)<minrange){
	            minrange=maxval-minval;
	            omin=minval;
	            omax=maxval;
	        }
	    }
	}
}

Approach 2: AC

class Solution
{
	static int[] findSmallestRange(int[][] nums,int n,int k)
	{
	    int minx = 0, miny = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int[] next = new int[nums.length];
        boolean flag = true;
        PriorityQueue < Integer > min_queue = new PriorityQueue < Integer > ((i, j) -> nums[i][next[i]] - nums[j][next[j]]);
        for (int i = 0; i < nums.length; i++) {
            min_queue.offer(i);
            max = Math.max(max, nums[i][0]);
        }
        for (int i = 0; i < nums.length && flag; i++) {
            for (int j = 0; j < nums[i].length && flag; j++) {
                int min_i = min_queue.poll();
                if (miny - minx > max - nums[min_i][next[min_i]]) {
                    minx = nums[min_i][next[min_i]];
                    miny = max;
                }
                next[min_i]++;
                if (next[min_i] == nums[min_i].length) {
                    flag = false;
                    break;
                }
                min_queue.offer(min_i);
                max = Math.max(max, nums[min_i][next[min_i]]);
            }
        }
        return new int[] { minx, miny};
	}
}
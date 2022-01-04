Problem Link : https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1/#

class Solve {
    int[] findTwoElement(int arr[], int n) {
        
        int ans1=0;
        for(int i=0;i<n;i++){
            if(arr[Math.abs(arr[i])-1]<0){
                ans1=Math.abs(arr[i]);
                break;
            }
            else arr[Math.abs(arr[i])-1]*=-1;
        }
        int xor=ans1;
        for(int i=0;i<n;i++){
            xor^=(Math.abs(arr[i])^(i+1));
        }
        return new int[]{ans1,xor};
    }
}
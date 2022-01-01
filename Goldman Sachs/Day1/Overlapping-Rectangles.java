Problem link : https://practice.geeksforgeeks.org/problems/overlapping-rectangles1924/1/#

class Solution {
    int doOverlap(int l1[], int r1[], int l2[], int r2[]) {
        
        // for overlapping in horizontal direction
        if(r1[0]<l2[0] || r2[0]<l1[0]){
            return 0;
        }
        // for overlapping in vertical direction
        else if(l2[1]<r1[1] || l1[1]<r2[1]){
            return 0;
        }
        return 1;
    }
}
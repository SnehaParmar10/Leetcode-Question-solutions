class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] res = new int[n];       
        java.util.Arrays.sort(nums1);      
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++){
            arr[i][0] = nums2[i];
            arr[i][1] = i;
        }   
        java.util.Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int l = 0, r = n - 1;
        for(int i = n - 1; i >= 0; i--){
            if(nums1[r] > arr[i][0]){
                res[arr[i][1]] = nums1[r];
                r--;
            } else {
                res[arr[i][1]] = nums1[l];
                l++;
                
            }
        }      
        return res;
    }
}
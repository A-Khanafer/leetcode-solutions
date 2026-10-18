class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int index = 0;
        int index1 = 0;
        int index2 = 0;

        int[] tempArray = new int[nums1.length];

        while(index < m + n){
            if(index1 >= m){
                tempArray[index] = nums2[index2];
                index2++;
                index++; 
                continue;
            }else if(index2 >= n){
                tempArray[index] = nums1[index1];
                index1++;
                index++; 
                continue;                
            }

            if(nums1[index1] > nums2[index2]){
                tempArray[index] = nums2[index2];
                index2++;
            }else if(nums1[index1] <= nums2[index2]){
                tempArray[index] = nums1[index1];
                index1++;
            }

            index++;       
        }

        for(int i = 0; i < m+n; i++){
            nums1[i] = tempArray[i];
        }

    }
}
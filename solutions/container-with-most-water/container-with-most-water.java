class Solution {
    public int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int max = 0;
        while(leftIndex < rightIndex){
            
            int area = Math.min(height[leftIndex], height[rightIndex]) * (rightIndex - leftIndex);
            
            if(area > max){
                max = area;
            }

            if(height[leftIndex] > height[rightIndex]){
                rightIndex--;
            }else{
                leftIndex++;
            }

        }

        return max;
    }
}

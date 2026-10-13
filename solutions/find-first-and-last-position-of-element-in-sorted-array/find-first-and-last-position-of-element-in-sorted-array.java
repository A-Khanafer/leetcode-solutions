class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int[] answer = {-1, -1};

        if(nums.length == 0)return answer;
        while(left < right){
            int mid = left + (right - left)/2;

            if(nums[mid] >= target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        if(nums[left] == target && nums[right] == target) answer[0] = left;

        left = 0;
        right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left + 1)/2;

            if(nums[mid] > target){
                right = mid - 1;
            }else{
                if(left == mid){
                    right = mid;
                }else{
                    left = mid;
                }
            }
        }

        if(nums[left] == target && nums[right] == target) answer[1] = right;

        return answer;
    }
}
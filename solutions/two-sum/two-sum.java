import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
    
        HashMap<Integer, Integer> map = new HashMap();

        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];

            if(map.containsKey(complement)){
                int[] answer = {map.get(complement) , i};
                return answer;
            }

            map.put(nums[i], i);
        }

        return new int[0];
    }
}
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        int prefixSum = 0;

        HashMap<Integer, Integer> map = new HashMap();
        map.put(0,1);

        for(int num : nums){
            prefixSum += num;
            int previousPrefix = prefixSum - k;

            if(map.containsKey(previousPrefix)){
                count += map.get(previousPrefix);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;


    }
}
class Solution{
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List< int[] > answer = new ArrayList<>();
        int[] current = intervals[0];

        for(int i = 0; i < intervals.length - 1; i++){

            if(current[1] >= intervals[i + 1][0]){
                current[0] = Math.min(current[0], intervals[i + 1][0]);
                current[1] = Math.max(current[1], intervals[i + 1][1]);                
            }else{
                answer.add(current);
                current = intervals[i + 1];
            }
        }

        answer.add(current);

        return answer.toArray(new int[0][]);

    }

}
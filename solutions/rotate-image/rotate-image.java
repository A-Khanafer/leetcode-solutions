class Solution {
    public void rotate(int[][] matrix) {

        HashMap<List<Integer>, Integer> map = new HashMap<>();

        int n = matrix.length - 1;

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){

                map.put(List.of(i, j), matrix[i][j]);

            }
        }

        for(List<Integer> indexes : map.keySet()){
            int row = indexes.get(0);
            int col = indexes.get(1);
            
            matrix[col][n - row] = map.get(indexes);
        }
    }
}
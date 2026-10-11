class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        int freshOranges = 0;

        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 2){
                    queue.offer(new int[]{row, col});
                }else if(grid[row][col] == 1){
                    freshOranges++;
                }
            }
        }

        int minutes = 0;

        if(freshOranges == 0)return minutes;

        while(!queue.isEmpty() && freshOranges > 0){
            
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                int[] cell = queue.poll();//Remove it from queue then visit it
                int row = cell[0];
                int col = cell[1];

                // Check the four adjacent cells
                //Up
                if(row > 0 == true){
                    if(grid[row - 1][col] == 1){
                        grid[row - 1][col] = 2;
                        queue.offer(new int[]{row - 1, col});
                        freshOranges--;
                    }
                }
                //Down
                if(row < (grid.length - 1) == true){
                    if(grid[row + 1][col] == 1){
                        grid[row + 1][col] = 2;
                        queue.offer(new int[]{row + 1, col});
                        freshOranges--;
                    }
                }
                //Left
                if(col > 0 == true){
                    if(grid[row][col - 1] == 1){
                        grid[row][col - 1] = 2;
                        queue.offer(new int[]{row, col - 1});
                        freshOranges--;
                    }
                }        
                //Right
                if(col < (grid[0].length - 1) == true){
                    if(grid[row][col + 1] == 1){
                        grid[row][col + 1] = 2;
                        queue.offer(new int[]{row, col + 1});
                        freshOranges--;
                    }
                }        
            }
            minutes++;
        }

        if(freshOranges == 0){
            return minutes;
        }
        
        return -1;



    }
}
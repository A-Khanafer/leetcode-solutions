class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int islands = 0;
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(!visited[row][col] && grid[row][col] == '1'){
                    islands++;
                    dfs(grid, visited, row, col);
                }
            }
        }
        return islands;
    }


    private void dfs(char[][] grid, boolean[][] visited, int row, int col) {

        // 1. Base cases
        if(row < 0 || 
            col < 0 || 
            row >= grid.length || 
            col >= grid[0].length || 
            visited[row][col] || 
            grid[row][col] == '0'){

            return;
        }
        // 2. Mark current cell as visited
        visited[row][col] = true;
        // 3. Explore four neighbors:

        dfs(grid, visited, row - 1, col);//Up
        dfs(grid, visited, row + 1, col);//Down
        dfs(grid, visited, row, col - 1);//Left
        dfs(grid, visited, row, col + 1);//Right

    }
}
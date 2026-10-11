class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] state = new int[numCourses];

        // Create an empty neighbor list for each course
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] pair : prerequisites){
            int course = pair[1];
            int requisite = pair[0];
            graph.get(course).add(requisite);
        }

        // Check every course for cycles
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, state, graph)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(int course, int[] state, List<List<Integer>> graph){
        // Already on the current DFS path: cycle!
        if (state[course] == 1) return true;
        // Already fully explored: no cycle here
        if (state[course] == 2) return false;

        // Mark as currently exploring
        state[course] = 1;
        // Explore neighbors
        for (int neighbor : graph.get(course)) {
            if (hasCycle(neighbor, state, graph)) {
                return true;
            }
        }
        // All neighbors explored successfully
        state[course] = 2;

        return false;
    }
}
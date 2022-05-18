
public class Lab10 {

    /**
     
     * @param n  = number of kingdoms
     * @param listOfConflicts list of conflicts
     * @return number of kingdoms will survive after those conflicts
     * @throws IllegalArgumentException in cases where there are more kingdoms that want to fight.
     */
    public static int survivedKingdoms(int n, int[][] listOfConflicts) {
        if (n > 1000 || n < 0) {
            throw new IllegalArgumentException();
        }

        int[][] graph = new int[n][n];
        boolean[] visited = new boolean[n];


        for (int i = 0; i < listOfConflicts.length; i++) {
            int u = listOfConflicts[i][0];
            int v = listOfConflicts[i][1];
            if (u >= n || v >= n) {
                throw new IllegalArgumentException();
            }
            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(graph, visited, i);
            }
        }

        return count;
    }

    /**
     * Depth-first search to visit connected nodes.
     *
     * @param graph   information about graph
     * @param visited information about visitation
     * @param u       root node
     */
    private static void dfs(int[][] graph, boolean[] visited, int u) {
        visited[u] = true;
        for (int v = 0; v < graph[u].length; v++) {
            if (graph[u][v] == 1) {
                if (!visited[v]) {
                    dfs(graph, visited, v);
                }
            }
        }

    }

    public static void main(String[] args) {
        int n = 10;
        int[][] arr = {{4,5}, {5,2}, {2,7}, {3,6}, {7,6}};
        System.out.println(Lab10.survivedKingdoms(n, arr));
    }
}
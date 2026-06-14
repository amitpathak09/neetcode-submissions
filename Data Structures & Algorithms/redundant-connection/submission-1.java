class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            // Before adding the edge, check if u and v are already connected
            if (dfs(u, v, -1, adj, new boolean[n + 1])) {
                return edge; // This edge is the one that creates the cycle!
            }
            // If not connected, add the edge to the graph
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return new int[0];
    }

    private boolean dfs(int source, int target, int parent, List<List<Integer>> adj, boolean[] visited) {
        if (source == target) return true;
        visited[source] = true;
        for (int neighbor : adj.get(source)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, target, source, adj, visited)) return true;
            }
        }
        return false;
    }
}
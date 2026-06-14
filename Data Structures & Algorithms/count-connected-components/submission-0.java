class Solution {
    public int countComponents(int n, int[][] edges) {

        List<Integer>[] adj = new ArrayList[n];
        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] edge: edges) {
            int u=edge[0];
            int v=edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        boolean[] visited = new boolean[n];
        int count=0;
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                count++;
                dfs(i, adj, visited);
            }
        }
        return count;
    }

    private void dfs(int node, List<Integer>[] adj, boolean[] visited) {
        visited[node] = true;
        for(Integer neighbour: adj[node]) {
            if(!visited[neighbour]) {
                dfs(neighbour, adj, visited);
            }
        }
    }
}

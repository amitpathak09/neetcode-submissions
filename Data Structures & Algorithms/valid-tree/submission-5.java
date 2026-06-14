class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1) {
            return false;
        }
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
        if(!dfs(0, -1, adj, visited)) {
            return false;
        }
        for(boolean visit: visited) {
            if(visit==false) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, int parent, List<Integer>[] adj, boolean[] visited) {
        visited[node]=true;
        for(int neighbour: adj[node]) {
            if(visited[neighbour]) {
                if(neighbour!=parent) {
                    return false;
                }
                
            } else {
                
                if(!dfs(neighbour, node, adj, visited)) {
                    return false;
                };
            }
        }
        return true;
    }
}

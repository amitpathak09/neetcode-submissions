class UnionFind {
    int[] parents;
    int[] size;

    public UnionFind(int n) {
        this.parents = new int[n];
        this.size = new int[n];
        for(int i=0; i<n; i++) {
            parents[i]=i;
            size[i]=1;
        }
    }

    public int find(int a) {
        if(parents[a]==a) {
            return a;
        }
        int ultiParent = find(parents[a]);
        parents[a] = ultiParent;
        return ultiParent;
    }

    public boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if(rootA == rootB) {
            return false;
        } else if(size[rootA]<size[rootB]) {
            parents[rootA] = rootB;
            size[rootB] = size[rootA]+size[rootB];
            return true;
        } else {
            parents[rootB] = rootA;
            size[rootA] = size[rootA] + size[rootB];
            return true;
        }
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length+1);

        for(int[] edge: edges) {
            if(!uf.union(edge[0],edge[1])) {
                return edge;
            }
        }
        return new int[2];
        
    }
}

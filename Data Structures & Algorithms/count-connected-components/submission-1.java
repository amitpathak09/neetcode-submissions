class UnionFind {
    int[] ultimateParents;
    int[] sizes;
    public UnionFind(int n) {
        ultimateParents = new int[n];
        sizes = new int[n];

        for(int i=0; i<n; i++) {
            ultimateParents[i]=i;
            sizes[i]=1;
        }
    }

    public boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if(rootA==rootB) {
            return false; 
        } else if(sizes[rootA]<sizes[rootB]) {
            ultimateParents[rootA]=rootB;
            sizes[rootB]=sizes[rootA]+sizes[rootB];
            return true;
        } else {
            ultimateParents[rootB] = rootA;
            sizes[rootA]=sizes[rootA]+sizes[rootB];
            return true;
        }
    }

    public int find(int a) {
        if(ultimateParents[a]==a) {
            return a;
        }
        int ultP = find(ultimateParents[a]);
        ultimateParents[a] = ultP;
        return ultP;
    }
}

class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int[] edge: edges) {
            if(uf.union(edge[0], edge[1])) {
                n--;
            }
        }
        return n;
    }
}

package PS.educative.graph;  
  /*   
   Bluemoon
   15/08/21 9:52 PM  
   */

public class ConnectedComponentsUnionFind {
    public static void main(String[] args) {
        ConnectedComponentsUnionFind componentsUnionFind = new ConnectedComponentsUnionFind();
        int[][] grid = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
        int n = componentsUnionFind.findCircleNum(grid);
        System.out.println(n);

    }

    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length < 1) {
            return 0;
        }
        int n = isConnected.length;
        UnionFind unionFind = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i != j) && !unionFind.connected(i, j) && isConnected[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.size;
    }

    class UnionFind {
        int[] parent;
        int[] rank; //rank is defined by height
        int size;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            this.size = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        // union by rank and find by path compression
        void union(int x, int y) {
            int root_x = find(x);
            int root_y = find(y);
            if (root_x == root_y) {
                return;
            }
            if (rank[x] > rank[y]) {
                parent[root_y] = root_x; // connect root of shorter tree to root of other tree
            } else if (rank[y] > rank[x]) {
                parent[root_x] = root_y;
            } else {
                parent[root_y] = root_x;
                rank[x] = rank[x] + 1; // since height of both trees are same so after connecting with root of 1 tree overall height of parent tree will increase by 1
            }
            this.size--;
        }

        int find(int x) {
            if (x == parent[x]) {
                return x;
            }
            return parent[x] = find(parent[x]); // path compression via recursion
        }

        boolean connected(int x, int y) {
            return find(x) == find(y);
        }

        int getSize() {
            return this.size;
        }
    }
}

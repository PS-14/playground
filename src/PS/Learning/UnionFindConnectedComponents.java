package PS.Learning;  
  /*   
   Bluemoon
   28/07/21 1:04 PM  
   */

public class UnionFindConnectedComponents {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }
        int countZero = 0;
        int r = grid.length;
        int c = grid[0].length;
        UnionFind unionfind = new UnionFind(r * c);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '0') {
                    countZero++;
                } else if (validPoint(i, j + 1, grid)) {
                    unionfind.union(i * c + j + 1, i * c + j);
                } else if (validPoint(i + 1, j, grid)) {
                    unionfind.union((i + 1) * c + j, i * c + j);
                }
            }
        }
        if (countZero > 1) {
            unionfind.totalComponents = unionfind.totalComponents - countZero + 1;
        }
        return unionfind.totalComponents;
    }

    private boolean validPoint(int i, int j, char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        if (i < 0 || i >= r || j < 0 || j >= c || grid[i][j] == '0') {
            return false;
        }
        return true;
    }

    private static class UnionFind {
        private int totalComponents;
        private int[] array;

        public UnionFind(int m) {
            array = new int[m];
            for (int i = 0; i < m; i++) {
                array[i] = i;
            }
            totalComponents = m;
        }

        public boolean find(int i, int j) {
            int root_i = root(i);
            int root_j = root(j);
            return root_i == root_j;
        }

        public void union(int i, int j) {
            int root_i = root(i);
            int root_j = root(j);
            if (root_i == root_j) {
                return;
            }
            array[root_i] = root_j;
            totalComponents--;
        }

        public int root(int i) {
            while (array[i] != i) {
                i = array[i];
            }
            return i;
        }
    }

    public static void main(String[] args) {
        UnionFindConnectedComponents ucf = new UnionFindConnectedComponents();
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {
                        '1', '1', '0', '0', '0'
                },
                {
                        '0', '0', '1', '0', '0'
                },
                {
                        '0', '0', '0', '1', '1'
                }
        };

        System.out.println(ucf.numIslands(grid));
    }
}

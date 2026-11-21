
class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        // Start DFS from Pacific Ocean boundaries
        // Pacific touches top and left boundaries

        for (int i = 0; i < n; i++) {
            dfs(heights, i, 0, pacific);
        }

        for (int j = 0; j < m; j++) {
            dfs(heights, 0, j, pacific);
        }

        // Start DFS from Atlantic Ocean boundaries
        // Atlantic touches bottom and right boundaries

        for (int i = 0; i < n; i++) {
            dfs(heights, i, m - 1, atlantic);
        }

        for (int j = 0; j < m; j++) {
            dfs(heights, n - 1, j, atlantic);
        }

        List<List<Integer>> ans = new ArrayList<>();

        // Find cells reachable from both oceans
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    void dfs(int[][] heights, int r, int c,
             boolean[][] visited) {

        // Already visited
        if (visited[r][c]) {
            return;
        }

        visited[r][c] = true;

        // Four possible directions
        int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        for (int[] d : dir) {

            int nr = r + d[0];
            int nc = c + d[1];

            // Check boundaries
            if (nr < 0 || nc < 0 ||
                nr >= heights.length ||
                nc >= heights[0].length) {
                continue;
            }

            // Reverse flow:
            // Move only to cells with equal or greater height
            if (heights[nr][nc] >= heights[r][c]) {
                dfs(heights, nr, nc, visited);
            }
        }
    }
}

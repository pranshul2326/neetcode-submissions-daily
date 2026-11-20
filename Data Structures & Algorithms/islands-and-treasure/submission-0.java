
class Solution {

    public void islandsAndTreasure(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Add all treasure chests to Queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // Four directions
        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        // Step 2: BFS
        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int i = current[0];
            int j = current[1];

            for (int[] dir : directions) {

                int x = i + dir[0];
                int y = j + dir[1];

                // Check boundaries and traversability
                if (x < 0 || y < 0 ||
                    x >= n || y >= m ||
                    grid[x][y] != Integer.MAX_VALUE) {
                    continue;
                }

                // Update distance
                grid[x][y] = grid[i][j] + 1;

                // Add to Queue
                queue.offer(new int[]{x, y});
            }
        }
    }
}

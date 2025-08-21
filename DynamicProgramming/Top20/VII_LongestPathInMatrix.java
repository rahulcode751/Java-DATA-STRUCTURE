package Top20;

public class VII_LongestPathInMatrix
{
    static int longestPath(int i, int j, int[][] matrix) {
        int ans = 1;

        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];

            if (x >= 0 && x < matrix.length && y >= 0 &&
                    y < matrix[0].length && matrix[x][y] == matrix[i][j] + 1) {
                ans = Math.max(ans, 1 + longestPath(x, y, matrix));
            }
        }
        return ans;
    }
    static int longestIncreasingPath(int[][] matrix) {
        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int val = longestPath(i, j, matrix);
                ans = Math.max(ans, val);
            }
        }

        return ans;
    }
}

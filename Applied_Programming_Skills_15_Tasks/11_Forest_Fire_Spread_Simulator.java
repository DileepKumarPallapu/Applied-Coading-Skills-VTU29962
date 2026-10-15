import java.util.*;

public class ForestFireSpreadSimulator {
    static class Cell {
        int row, col;
        Cell(int row, int col) { this.row = row; this.col = col; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt(), cols = sc.nextInt();
        int[][] grid = new int[rows][cols];
        Queue<Cell> queue = new LinkedList<>();
        int trees = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid[r][c] = sc.nextInt();
                if (grid[r][c] == 2) queue.offer(new Cell(r, c));
                else if (grid[r][c] == 1) trees++;
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int minutes = 0;

        while (!queue.isEmpty() && trees > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Cell current = queue.poll();
                for (int[] d : directions) {
                    int nr = current.row + d[0], nc = current.col + d[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        trees--;
                        queue.offer(new Cell(nr, nc));
                    }
                }
            }
            minutes++;
        }

        System.out.println(trees == 0 ? "Minutes = " + minutes : "Minutes = -1");
    }
}

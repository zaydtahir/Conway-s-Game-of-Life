import java.awt.*;
import java.util.Random;

public class Main {

    private static int[][] grid;
    private static int cols, rows;
    private static Frame frame;
    private static boolean running;
    private static int w, h;

    public static void main(String[] args) {
        frame = new Frame();
        cols = 50;
        rows = 50;
        grid = new int[cols][rows];
        w = (int) Math.floor(frame.draw.getPreferredSize().width / cols);
        h = (int) Math.floor(frame.draw.getPreferredSize().height / rows);

        running = true;

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                grid[i][j] = new Random().nextInt(2);
            }
        }

        while (running) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            frame.repaint();
            newGeneration();

        }
    }

    private static void newGeneration() {
        int[][] oldGen = grid;

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                int liveNeighbors = countLiveNeighbors(oldGen, i, j);
                // Cell is lonely and dies
                if ((oldGen[i][j] == 1) && (liveNeighbors < 2))
                    grid[i][j] = 0;

                    // Cell dies due to over population
                else if ((oldGen[i][j] == 1) && (liveNeighbors > 3))
                    grid[i][j] = 0;

                    // A new cell is born
                else if ((oldGen[i][j] == 0) && (liveNeighbors == 3))
                    grid[i][j] = 1;
            }
        }
    }

    private static int countLiveNeighbors(int[][] grid, int x, int y) {
        int sum = 0;
        for (int i = -1; i <= 1; i++)
            for (int j = -1; j <= 1; j++)

                try {
                    sum += grid[x + i][y + j];
                }
        catch (ArrayIndexOutOfBoundsException f){
                    continue;
        }

        sum -= grid[x][y];
        return sum;
    }

    public static void drawCells(Graphics g) {
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (grid[i][j] == 1) g.setColor(Color.white);
                else g.setColor(Color.black);
                g.fillRect(i * w, j * h, w, h);
            }
        }
    }
}

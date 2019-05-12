import java.awt.*;
import java.io.IOException;
import java.io.Writer;

@SuppressWarnings("unused")
public class TestArrayWorld implements World {

    private int generation;
    private int width;
    private int height;
    private boolean[][] cells;

    @SuppressWarnings("unused")
    public TestArrayWorld(int w, int h) {
        width = w;
        height = h;
        cells = new boolean[h][w];
        generation = 0;
    }

    private TestArrayWorld(TestArrayWorld prev) {
        width = prev.width;
        height = prev.height;
        generation = prev.generation + 1;
        cells = new boolean[height][width];
    }

    public boolean getCell(int col, int row) {
        return row >= 0 && col >= 0 && row < cells.length && col < cells[row].length && cells[row][col];
    }

    public void setCell(int col, int row, boolean alive) {
        if (row >= 0 && col >= 0 && row < cells.length && col < cells[row].length) {
            cells[row][col] = alive;
        }
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public int getGeneration() {
        return generation;
    }
    public int getPopulation() {
        return 0;
    }
    public void print(Writer w) throws IOException {
        w.write("****************");
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                w.append(getCell(col, row) ? "#" : "_");
            }
            w.write("");
        }
    }
    public void draw(Graphics g, int width, int height)  { /*Leave empty*/ }

    private TestArrayWorld nextGeneration() {
        //Construct a new TestArrayWorld object to hold the next generation:
        TestArrayWorld nextGenWorld = new TestArrayWorld(this);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                nextGenWorld.setCell(j, i, getCell(j, i));
            }
        }
        return nextGenWorld;
    }

    public World nextGeneration(int log2StepSize)  {
        TestArrayWorld cells = this;
        //TODO: repeat the statement in curly brackets 2^log2StepSize times
        for (int i = 0; i < Math.pow(2, log2StepSize); i++) {
            cells = cells.nextGeneration();
        }
        return cells;
    }

    //TODO: Add any other private methods which you find helpful
}
import java.awt.*;
import java.io.IOException;
import java.io.Writer;

public interface World {
    public void setCell(int col, int row, boolean alive);
    public boolean getCell(int col, int row);
    public int getWidth();
    public int getHeight();
    public int getGeneration();
    public int getPopulation();
    public void print(Writer w) throws IOException;
    public void draw(Graphics g, int width, int height);
    public World nextGeneration(int log2StepSize);
}
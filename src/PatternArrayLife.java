import java.util.Arrays;

public class PatternArrayLife {

    public static void main(String[] args) throws Exception {
            Pattern pattern;
            try {
                pattern = new Pattern(args[0]);
            } catch (PatternFormatException e) {
                System.out.println("Error: Unable to parse " + Arrays.toString(args));
                return;
            }
            boolean[][] world = new boolean[pattern.getHeight()][pattern.getWidth()];
            try {
                pattern.initialise(world);

            } catch (PatternFormatException e) {
                System.out.println("Error: Unable to parse " + Arrays.toString(args));
            }
            play(world);
    }

    private static void updateWorld(boolean[][] world, int startRow, int startCol, boolean[][] cells) {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                world[startRow + i][startCol + j] = cells[i][j];
            }
        }
    }

    public static int countNeighbours(boolean[][] world, int col, int row) {
        int count = 0;
        count += getCell(world, col - 1, row - 1) ? 1 : 0; // above and left
        count += getCell(world, col - 1, row) ? 1 : 0; // to the left
        count += getCell(world, col - 1, row + 1) ? 1 : 0; // below and left
        count += getCell(world, col, row + 1) ? 1 : 0; // below
        count += getCell(world, col + 1, row + 1) ? 1 : 0; // below and right
        count += getCell(world, col + 1, row) ? 1 : 0; // to the right
        count += getCell(world, col + 1, row - 1) ? 1 : 0; // above and right
        count += getCell(world, col, row - 1) ? 1 : 0; // above
        return count;
    }

    public static boolean computeCell(boolean[][] world, int col, int row) {
        boolean currentCellState = getCell(world, col, row);
        int neighbors = countNeighbours(world, col, row);
        boolean nextCellState = false;

        // A live cell with less than two neighbors dies (underpopulation)
        // A live cell with two or three neighbors lives (a balanced population)
        // A live cell with with more than three neighbors dies (overcrowding)
        // A dead cell with exactly three live neighbors comes alive (colonization)

        if (neighbors == 3) {
            nextCellState = true;
        } else if (neighbors == 2) {
            nextCellState = currentCellState;
        }
        return nextCellState;
    }

    public static boolean[][] nextGeneration(boolean[][] world) {
        boolean[][] nextWorld = new boolean[world.length][world[0].length];
        for (int col = 0; col < Long.BYTES; col++) {
            for (int row = 0; row < Long.BYTES; row++) {
                boolean nextState = computeCell(world, col, row);
                setCell(nextWorld, col, row, nextState);
            }
        }
        return nextWorld;

    }

    public static boolean getCell(boolean[][] world, int col, int row) {
        return row >= 0 && col >= 0 && row < world.length && col < world[row].length && world[row][col];
    }

    public static void setCell(boolean[][] world, int col, int row, boolean value) {
        if (row >= 0 && col >= 0 && row < world.length && col < world[row].length) {
            world[row][col] = value;
        }
    }

    public static void print(boolean[][] world) {
        System.out.println("****************");
        for (int row = 0; row < world.length; row++) {
            for (int col = 0; col < world[row].length; col++) {
                System.out.print(getCell(world, col, row) ? "#" : "_");
            }
            System.out.println();
        }
    }

    public static void play(boolean[][] world) throws Exception {
        int userResponse = 0;
        while (userResponse != 'q') {
            print(world);
            userResponse = System.in.read();
            world = nextGeneration(world);
        }
    }
}

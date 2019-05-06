public class TinyLife {

    public static void main(String[] args) throws Exception {
        play(Long.decode(args[0]));
    }

    public static int countNeighbours(long world, int col, int row) {
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

    public static boolean computeCell(long world, int col, int row) {
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

    public static long nextGeneration(long world) {
        Long nextWorld = 0L;
        for (int col = 0; col < Long.BYTES; col++) {
        for (int row = 0; row < Long.BYTES; row++) {
                boolean nextState = computeCell(world, col, row);
                nextWorld = setCell(nextWorld, col, row, nextState);
            }
        }
        return nextWorld;

    }

    public static int getPosition(int col, int row) {
        return row * Long.BYTES + col;
    }

    public static boolean getCell(long world, int col, int row) {
        return row >= 0 && col >= 0 && row <= 7 && col <= 7 && PackedLong.get(world, getPosition(col, row));

    }

    public static long setCell(long world, int col, int row, boolean value) {
        if (row >= 0 && col >= 0 && row <= 7 && col <= 7) {
            world = PackedLong.set(world, getPosition(col, row), value);
        }
        return world;
    }

    public static void print(long world) {
        System.out.println("****************");
        for (int row = 0; row < Long.BYTES; row++) {
            for (int col = 0; col < Long.BYTES; col++) {
                System.out.print(getCell(world, col, row) ? "#" : "_");
            }
            System.out.println();
        }
    }

    public static void play(long world) throws Exception {
        int userResponse = 0;
        while (userResponse != 'q') {
            print(world);
            userResponse = System.in.read();
            world = nextGeneration(world);
        }
    }
}

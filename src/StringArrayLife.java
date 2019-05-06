public class StringArrayLife {

    public static void main(String[] args) throws Exception {
        //"Glider:Richard Guy (1970):20:20:1:1:010 001 111"
        String[] inputArr = args[0].split(":");
        String name = inputArr[0];
        String author = inputArr[1];
        int width = Integer.parseInt(inputArr[2]);
        int height = Integer.parseInt(inputArr[3]);
        int startCol = Integer.parseInt(inputArr[4]);
        int startRow = Integer.parseInt(inputArr[5]);
        String[] cellsStrArr = inputArr[6].split(" ");
        boolean[][] cells = new boolean[cellsStrArr.length][cellsStrArr[0].length()];
        for (int i = 0; i < cellsStrArr.length; i++) {
            for (int j = 0; j < cellsStrArr[0].length(); j++) {
                cells[i][j] = cellsStrArr[i].charAt(j) - '0' == 1;
            }
        }
//
//        for (int i = 0; i < cells.length; i++) {
//            for (int j = 0; j < cells[i].length; j++) {
//                System.out.print(cells[i][j]);
//            }
//            System.out.println("");
//        }

        boolean[][] world = new boolean[height][width];
        updateWorld(world, startRow, startCol, cells);
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

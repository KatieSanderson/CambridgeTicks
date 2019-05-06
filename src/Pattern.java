public class Pattern {

    private String name;
    private String author;
    private int width;
    private int height;
    private int startCol;
    private int startRow;
    private String cells;

    public Pattern(String format) {
        //"Glider:Richard Guy (1970):20:20:1:1:010 001 111"
        String[] inputArr = format.split(":");
        name = inputArr[0];
        author = inputArr[1];
        width = Integer.parseInt(inputArr[2]);
        height = Integer.parseInt(inputArr[3]);
        startCol = Integer.parseInt(inputArr[4]);
        startRow = Integer.parseInt(inputArr[5]);
        cells = inputArr[6];
    }

    public void initialise(boolean[][] world) {
        String[] cellsStrArr = cells.split(" ");
        for (int i = 0; i < cellsStrArr.length; i++) {
            for (int j = 0; j < cellsStrArr[0].length(); j++) {
                world[i + startRow][j + startCol] = cellsStrArr[i].charAt(j) - '0' == 1;
            }
        }
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getStartCol() {
        return startCol;
    }

    public int getStartRow() {
        return startRow;
    }

    public String getCells() {
        return cells;
    }
}
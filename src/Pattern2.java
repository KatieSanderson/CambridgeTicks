public class Pattern2 {

    private String format;
    private String name;
    private String author;
    private int width;
    private int height;
    private int startCol;
    private int startRow;
    private String cells;

    @SuppressWarnings("unused")
    public Pattern2(World world) throws PatternFormatException {
        String[] inputArr = format.split(":");
        if (inputArr.length < 7) {
            throw new PatternFormatException();
        }
        name = inputArr[0];
        author = inputArr[1];
        try {
            width = Integer.parseInt(inputArr[2]);
            height = Integer.parseInt(inputArr[3]);
            startCol = Integer.parseInt(inputArr[4]);
            startRow = Integer.parseInt(inputArr[5]);
        } catch (NumberFormatException e) {
            throw new PatternFormatException();
        }
        cells = inputArr[6];
    }

    @SuppressWarnings("unused")
    public void initialise(World world) throws PatternFormatException {
//        try {
            String[] cellsStrArr = cells.split(" ");
            for (int i = 0; i < cellsStrArr.length; i++) {
                for (int j = 0; j < cellsStrArr[0].length(); j++) {
                    int value = cellsStrArr[i].charAt(j) - '0';
                    if (value != 1 && value != 0) {
                        throw new PatternFormatException();
                    }
                    world.setCell(j + startCol, i + startRow, value == 1);
                }
            }
//        } catch (PatternFormatException e) {
//            System.out.println("Error: Unable to parse [" + cells + "]");
//        }
    }

    @SuppressWarnings("unused")
    public String getFormat() {
        return format;
    }

    @SuppressWarnings("unused")
    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    public String getAuthor() {
        return author;
    }

    @SuppressWarnings("unused")
    public int getWidth() {
        return width;
    }

    @SuppressWarnings("unused")
    public int getHeight() {
        return height;
    }

    @SuppressWarnings("unused")
    public int getStartCol() {
        return startCol;
    }

    @SuppressWarnings("unused")
    public int getStartRow() {
        return startRow;
    }

    @SuppressWarnings("unused")
    public String getCells() {
        return cells;
    }
}
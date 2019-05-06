public class Pattern {

    private String name;
    private String author;
    private int width;
    private int height;
    private int startCol;
    private int startRow;
    private String cells;

    public Pattern(String[] format) throws PatternFormatException {
        //"Glider:Richard Guy (1970):20:20:1:1:010 001 111"
//        try {
            if (format.length < 1) {
                throw new PatternFormatException();
            }
            String[] inputArr = format[0].split(":");
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
//        } catch (PatternFormatException e) {
//            System.out.println("Error: Unable to parse " + Arrays.toString(format));
//        }
    }

    public void initialise(boolean[][] world) throws PatternFormatException {
//        try {
            String[] cellsStrArr = cells.split(" ");
            for (int i = 0; i < cellsStrArr.length; i++) {
                for (int j = 0; j < cellsStrArr[0].length(); j++) {
                    int value = cellsStrArr[i].charAt(j) - '0';
                    if (value != 1 && value != 0) {
                        throw new PatternFormatException();
                    }
                    world[i + startRow][j + startCol] = value == 1;
                }
            }
//        } catch (PatternFormatException e) {
//            System.out.println("Error: Unable to parse [" + cells + "]");
//        }
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
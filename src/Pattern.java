public class Pattern {

    private String name;
    private String author;
    private int width;
    private int height;
    private int startCol;
    private int startRow;
    private String cells;
    //TODO: write public "get" methods for EACH of the fields above;
    //      for instance "getName" should be written as:
    public String getName() {
        return name;
    }

    public Pattern(String format) {
        //TODO: initialise all fields of this class using contents of "format"
        //      to determine the correct values.
    }

    public void initialise(boolean[][] world) {
        //TODO: update the values in the 2D array representing the state of "world"
        //      as expressed by the contents of the field "cells".
    }
}
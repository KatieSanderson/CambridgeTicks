public class Repeat {
    public static void main(String[] args) {
        System.out.println(parseAndRep(args));
    }

    /*
     * Return the first string repeated by the number of times
     * specified by the integer in the second string, for example
     *
     *    parseAndRep(new String[]{"one","3"})
     *
     * should return "one one one". Adjacent copies of the repeated
     * string should be separated by a single space.
     *
     * Return a suitable error message in a string when there are
     * not enough arguments in "args" or the second argument is
     * not a valid positive integer. For example:
     *
     *  - parseAndRep(new String[]{"one"}) should return
     *    "Error: insufficient arguments"
     *
     *  - parseAndRep(new String[]{"one","five"}) should return
     *    "Error: second argument is not a positive integer"
     */

    public static String parseAndRep(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("Error: insufficient arguments, requires 2, provided [" + args.length + "]");
        }
        int repeatNum = 0;
        String repeatString = args[0];
        try {
            repeatNum = Integer.parseInt(args[1]);
            if (repeatNum < 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: second argument [" + args[1] + "] is not a positive integer");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < repeatNum; i++) {
            sb.append(repeatString);
        }
        return sb.toString();
    }
}
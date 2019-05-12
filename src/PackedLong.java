public class PackedLong {

    /*
     * Unpack and return the nth bit from the packed number at index position;
     * position counts from zero (representing the least significant bit)
     * up to 63 (representing the most significant bit).
     */
    static boolean get(long packed, int position) {
        // set "check" to equal 1 if the "position" bit in "packed" is set to 1
        long check = (packed >> position) & 1;

        return (check == 1);
    }
    /*
     * Set the nth bit in the packed number to the value given
     * and return the new packed number
     */
    static long set(long packed, int position, boolean value) {
        if (value) {
            packed |= (1L << position);
            // update the value "packed" with the bit at "position" set to 1
        }
        else {
            packed &= ~(1L << position);
            // update the value "packed" with the bit a "position" set to 0
        }
        return packed;
    }

    @SuppressWarnings("unused")
    public static void printInBinary(long value) {
        for (int i = 63; i >= 0; i--) {
            System.out.print((value & (1L << i)) == 0 ? 0 : 1);
        }
        System.out.println();
    }
}

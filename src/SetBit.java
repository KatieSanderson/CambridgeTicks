public class SetBit {
    public static void main(String [] args) throws Exception {
        long currentValue = 85L;
        int position = 2;
        boolean value = false;
        currentValue = PackedLong.set(currentValue,position,value);
        System.out.println(currentValue);
    }
}
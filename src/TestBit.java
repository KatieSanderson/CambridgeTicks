public class TestBit {
    public static void main(String[] args) throws Exception {
        long currentValue = 85L;
        int position = 4;
        boolean value = PackedLong.get(currentValue, position);
        System.out.println(value);
    }
}

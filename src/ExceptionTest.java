class ExceptionTest {
    public static void main(String[] args) {
        System.out.print("C");
        try {
            a();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        System.out.println("A");
    }

    public static void a() throws Exception {
        System.out.print("S");
        b();
        System.out.print("J");
    }

    private static void b() throws Exception {
        System.out.print("T");
        throw new Exception("1");
    }
}
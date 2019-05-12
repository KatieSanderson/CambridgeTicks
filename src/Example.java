public class Example {

    public static void main(String[] args) {
         int i = 0;
         IClass pizza = new IClass(i);
         IClass example2 = new IClass(i);
         setI(new IClass(i));
         i = setI(i);
         System.out.println("primitive i: " + i);
         System.out.println("object i: " + example.i);
    }

    private static void setI(IClass example) {
        example.i++;
    }

    private static int setI(int i) {
        i++;
        return i;
    }


}

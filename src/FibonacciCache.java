public class FibonacciCache {
    public static long[] fib = new long[20];

    public static void store() {
        if (fib.length > 0) {
            fib[0] = 1;
        }
        if (fib.length > 1) {
            fib[1] = 1;
        }
        for (int i = 2; i < fib.length; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
    }

    public static void reset() {
        for (int i = 0; i < fib.length; i++) {
            fib[i] = 0;
        }
    }

    public static long get(int i) {
        return (i >= 0 && i < fib.length) ? fib[i] : -1L;
    }
}
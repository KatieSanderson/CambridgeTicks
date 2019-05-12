class FibonacciCache {
    static long[] fib = new long[20];

    static void store() {
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

    static void reset() {
        for (int i = 0; i < fib.length; i++) {
            fib[i] = 0;
        }
    }
}
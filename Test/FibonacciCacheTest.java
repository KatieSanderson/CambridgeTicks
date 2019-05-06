import org.junit.Assert;
import org.junit.Test;

public class FibonacciCacheTest {

    @Test
    public void store() {
        FibonacciCache.fib = new long[60];
        FibonacciCache.store();
        Assert.assertEquals(1, FibonacciCache.fib[0]);
        Assert.assertEquals(55, FibonacciCache.fib[9]);
        Assert.assertEquals(5, FibonacciCache.fib[4]);
        FibonacciCache.fib = new long[11];
        FibonacciCache.store();
        Assert.assertEquals(1, FibonacciCache.fib[0]);
        Assert.assertEquals(55, FibonacciCache.fib[9]);
        Assert.assertEquals(5, FibonacciCache.fib[4]);

    }

    @Test
    public void reset() {
        long[] nextFib = {3, 2, 89, -5, 23, 800};
        FibonacciCache.fib = nextFib;
        FibonacciCache.reset();
        for (int i = 0; i < FibonacciCache.fib.length; i++) {
            Assert.assertEquals(0, FibonacciCache.fib[i]);
        }
    }

    @Test
    public void get() {
        long[] nextFib = {3, 2, 89, -5, 23, 800};
        FibonacciCache.fib = nextFib;
        Assert.assertEquals(3, FibonacciCache.fib[0]);
    }
}
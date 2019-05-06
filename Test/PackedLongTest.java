import org.junit.Assert;
import org.junit.Test;

public class PackedLongTest {

    @Test
    public void set() {
        Assert.assertEquals(81, PackedLong.set(85, 2, false));
        Assert.assertEquals(5, PackedLong.set(1, 2, true));
        Assert.assertEquals(1104, PackedLong.set(80, 10, true));
        Assert.assertEquals(0, PackedLong.set(32, 5, false));
    }
}

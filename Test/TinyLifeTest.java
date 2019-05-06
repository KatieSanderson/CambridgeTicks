import org.junit.Assert;
import org.junit.Test;

public class TinyLifeTest {

    Long world = 0x20A0600000000000L;

    @Test
    public void getPosition() {
        Assert.assertEquals(0, TinyLife.getPosition(0, 0));
        Assert.assertEquals(15, TinyLife.getPosition(7, 1));
        Assert.assertEquals(63, TinyLife.getPosition(7, 7));
        Assert.assertEquals(20, TinyLife.getPosition(4, 2));
    }

    @Test
    public void getCellTest() {
        Assert.assertFalse(TinyLife.getCell(world, 1, 1));
        Assert.assertFalse(TinyLife.getCell(world, -1, 1));
        Assert.assertFalse(TinyLife.getCell(world, 3, 8));
        Assert.assertFalse(TinyLife.getCell(world, 1, -12));
        Assert.assertFalse(TinyLife.getCell(world, 72, 2));
        Assert.assertTrue(TinyLife.getCell(world, 5, 5));
        Assert.assertTrue(TinyLife.getCell(world, 5, 6));
        Assert.assertFalse(TinyLife.getCell(world, 6, 6));
    }

    @Test
    public void setCellTest() {
        Long world = 0L;
        Assert.assertEquals(1, TinyLife.setCell(world, 0, 0, true));
        world = -1L;
        Assert.assertEquals(0xFFFFFFFFFFFFFFFEL, TinyLife.setCell(world, 0, 0, false));
    }

    @Test
    public void countNeighorsTest() {
        Assert.assertEquals(0, TinyLife.countNeighbours(world, 1, 1));
        Assert.assertEquals(1, TinyLife.countNeighbours(world, 7, 7));
        Assert.assertEquals(2, TinyLife.countNeighbours(world, 7, 5));
        Assert.assertEquals(3, TinyLife.countNeighbours(world, 6, 5));
        Assert.assertEquals(3, TinyLife.countNeighbours(world, 5, 6));
        Assert.assertEquals(1, TinyLife.countNeighbours(world, 7, 6));
        Assert.assertEquals(5, TinyLife.countNeighbours(world, 6, 6));
    }

    @Test
    public void computeCellTest() {
        Assert.assertFalse(TinyLife.computeCell(world, 1, 1));
        Assert.assertFalse(TinyLife.computeCell(world, 7, 7));
        Assert.assertFalse(TinyLife.computeCell(world, 7, 5));
        Assert.assertTrue(TinyLife.computeCell(world, 6, 5));
        Assert.assertTrue(TinyLife.computeCell(world, 5, 6));
        Assert.assertFalse(TinyLife.computeCell(world, 7, 6));
        Assert.assertFalse(TinyLife.computeCell(world, 6, 6));
    }
}
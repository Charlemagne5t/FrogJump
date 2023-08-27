import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void canCrossTest1() {
        int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
        boolean actual = new Solution().canCross(stones);

        Assert.assertTrue(actual);
    }

    @Test
    public void canCrossTest2() {
        int[] stones = {0, 1, 2, 3, 4, 8, 9, 11};
        boolean actual = new Solution().canCross(stones);

        Assert.assertFalse(actual);
    }
}

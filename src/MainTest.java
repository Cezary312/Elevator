import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest
{
    @Test
    public void shouldBeFalseWhenIsOutOfRange()
    {
        Assert.assertFalse(Main.checkHistoryLift(3, "GGGDDDD"));
        Assert.assertFalse(Main.checkHistoryLift(3, "GGGGDDD"));
        Assert.assertFalse(Main.checkHistoryLift(3, "GGGDDGGG"));
    }

    @Test
    public void shouldBeFalseWhenWrongLetterIsGiven()
    {
        Assert.assertFalse(Main.checkHistoryLift(3, "ABC"));
    }

    @Test
    public void shouldBeTrue()
    {
        Assert.assertTrue(Main.checkHistoryLift(3, "D"));
        Assert.assertTrue(Main.checkHistoryLift(3, "GGGDDGG"));
        Assert.assertTrue(Main.checkHistoryLift(2, "DGDGDGDGDGDG"));
    }
}
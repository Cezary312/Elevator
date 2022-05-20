import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest
{
    @Test
    public void shouldBeFalseWhenIsOutOfRange()
    {
        Assert.assertFalse(new Elevator(3, "GGGDDDGDDD").checkHistoryLift());
        Assert.assertFalse(new Elevator(3, "DGGGDGG").checkHistoryLift());
        Assert.assertFalse(new Elevator(3, "DDDD").checkHistoryLift());
        Assert.assertFalse(new Elevator(3, "DDGGGDDGGG").checkHistoryLift());
        Assert.assertFalse(new Elevator(3, "GGDDDGDD").checkHistoryLift());
    }

    @Test
    public void shouldBeFalseWhenWrongLetterIsGiven()
    {
        Assert.assertFalse(new Elevator(3, "GGA").checkHistoryLift());
        Assert.assertFalse(new Elevator(3, "GGGDDGGX").checkHistoryLift());
    }

    @Test
    public void shouldBeTrue()
    {
        Assert.assertTrue(new Elevator(3, "GGGDDDGD").checkHistoryLift());
        Assert.assertTrue(new Elevator(3, "D").checkHistoryLift());
        Assert.assertTrue(new Elevator(3, "GGGDGDDDGG").checkHistoryLift());
        Assert.assertTrue(new Elevator(3, "GGGDDD").checkHistoryLift());
    }
}
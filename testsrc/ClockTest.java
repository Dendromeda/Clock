import org.junit.Test;
import static org.junit.Assert.*;


public class ClockTest {

    @Test
    public void clockConstructed() throws Exception{
        Clock clk = new Clock();
        assertEquals(clk.getTime(), "00:00");
    }
    @Test
    public void constructedClockSet(){
        Clock clk = new Clock(13,37);
        assertEquals(clk.getTime(), "13:37");
    }

    @Test(expected = IllegalArgumentException.class)
    public void detectOutOfBoundsHours(){
        Clock clk = new Clock(25,14);
    }

    @Test(expected = IllegalArgumentException.class)
    public void detectOutOfBoundsMinutes(){
        Clock clk = new Clock(13,63);
    }

    @Test
    public void ticksCorrectly(){
        Clock clk = new Clock(13,36);
        clk.timeTick();
        assertEquals(clk.getTime(), "13:37");
    }

    @Test
    public void clockResets(){
        Clock clk = new Clock(23,59);
        clk.timeTick();
        assertEquals(clk.getTime(), "00:00");
    }
}

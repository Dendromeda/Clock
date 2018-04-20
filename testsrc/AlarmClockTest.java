import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class AlarmClockTest {


    @Test
    public void constructedSetRight(){
        AlarmClock clk = new AlarmClock(13,37);
        assertEquals(clk.getTime(), "13:37");
    }

    @Test
    public void alarmTriggered(){
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        AlarmClock clk = new AlarmClock(13,36);
        clk.setAlarm(13,37);
        clk.timeTick();
        assertEquals( outContent.toString().replaceAll("\r", "").
                replaceAll("\n", ""),"alarm");
        System.setOut(System.out);

    }
    @Test
    public void doesNotTriggerTurnedOff(){
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        AlarmClock clk = new AlarmClock(13,36);
        clk.setAlarm(13,37);
        clk.turnOff();
        clk.timeTick();
        assertEquals( outContent.toString().replaceAll("\r", "")
                .replaceAll("\n", ""),"");
        System.setOut(System.out);
    }
    @Test
    public void turnsOnAgain(){
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
       System.setOut(new PrintStream(outContent));
        AlarmClock clk = new AlarmClock(13,36);
        clk.setAlarm(13,37);
        clk.turnOff();
        clk.turnOn();
        clk.timeTick();
        assertEquals( outContent.toString().replaceAll("\r", "")
                .replaceAll("\n", ""),"alarm");
        System.setOut(System.out);
    }
    @Test
    public void triggersOnSet() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        AlarmClock clk = new AlarmClock(13, 36);
        clk.setAlarm(13, 37);
        clk.setTime(13,37);
        assertEquals(outContent.toString().replaceAll("\r", "")
                .replaceAll("\n", ""), "alarm");
        System.setOut(System.out);
    }

}

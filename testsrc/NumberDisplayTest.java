import org.junit.Test;
import static org.junit.Assert.*;


public class NumberDisplayTest {

    @Test(expected = IllegalArgumentException.class)
    public void doesNotSetValueIfOutOfBoundsLow(){
        NumberDisplay display = new NumberDisplay(10,100);
        display.setValue(5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void doesNotSetValueIfOutOfBoundsHigh(){
        NumberDisplay display = new NumberDisplay(10,100);
        display.setValue(110);
    }

    @Test
    public void setsRightValueAsDisplayString(){
        NumberDisplay display = new NumberDisplay(0,99);
        display.setValue(55);
        assertEquals(display.getDisplayValue(),"55");
    }

    @Test
    public void setsRightStringPadding(){
        NumberDisplay display = new NumberDisplay(0,1000);
        display.setValue(55);
        assertEquals(display.getDisplayValue(),"055");
    }

    @Test
    public void IncrementsCorrectly(){
        NumberDisplay display = new NumberDisplay(0,100);
        display.setValue(54);
        display.increment();
        assertEquals(display.getValue(), 55);
    }

    @Test
    public void doesWrapAround(){
        NumberDisplay display = new NumberDisplay(0,100);
        display.setValue(99);
        display.increment();
        assertEquals(display.getValue(), 0);
    }

    @Test
    public void triggersWrapAround(){
        NumberDisplay display = new NumberDisplay(0,100);
        display.setValue(99);
        display.increment();
        assertEquals(display.didWrapAround(), true);
    }
}

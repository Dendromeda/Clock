/**
 *
 */
public class NumberDisplay {
    private int minLimit;
    private int maxLimit;
    private int value;
    private boolean wrapFlag;

    /**
     * Constructs new Number display with given scope.
     *
     * @param min Minimum value of the display
     * @param max Maximum value of the display
     */
    public NumberDisplay(int min, int max) {
            maxLimit = max;
        minLimit = min;
        value = minLimit;
        wrapFlag = false;
    }

    /**
     * Returns value of display.
     *
     * @return value
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets value of display to input integer.
     *
     * @param val Integer to be set as value of display
     * @throws IllegalArgumentException Throws exception if given integer is outside scope of display
     */
    public void setValue(int val) throws IllegalArgumentException {
        if ((val < minLimit) || (val >= maxLimit)) {
            throw new IllegalArgumentException();
        }
        value = val;
    }

    /**
     * Pads value with zeros as String to match maximum value of display.
     *
     * @return formatted String
     */
    public String getDisplayValue() {
        int lim = 10;
        int fill = 0;
        String str = "";
        while (maxLimit-1 >= lim) {
            if (value < lim) {
                str = str + "0";
            }
            lim *= 10;
        }
        str = str + Integer.toString(value);
        return str;
    }

    /** Increases value of display by 1, wraps to minLimit and sets wrapFlag if exceeding maximum value.
     */
    public void increment() {
        value++;
        wrapFlag = false;
        if (value >= maxLimit) {
            value = minLimit;
            wrapFlag = true;
        }

    }

    /** Gets if last execution of increment made value wrapped around
     * @return boolean wrapFlag
     */
    public boolean didWrapAround() {
        return wrapFlag;
    }
}

public class Clock {

    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;

    /** Constructs new Clock with time set to 00:00
     */
    public Clock(){
        new Clock(0,0);
    }

    /** Constructs new clock with time set to argument values.
     *
     * @param hour value to set hour display to
     * @param minute value to set minute display to
     * @throws IllegalArgumentException if any of the arguments are outside scope of clock
     */
    public Clock(int hour, int minute) throws IllegalArgumentException{
        hours = new NumberDisplay(0, 24);
        minutes = new NumberDisplay(0, 60);
        this.setTime(hour, minute);
    }

    /** Tick clock one step.
     */
    public void timeTick(){
        minutes.increment();
        if (minutes.didWrapAround()){
            hours.increment();
        }
        updateDisplay();
    }

    /** Sets time to given argument values
     *
     * @param hour hour to set clock to
     * @param minute minute to set clock to
     * @throws IllegalArgumentException
     */
    public void setTime(int hour, int minute) throws IllegalArgumentException{
        hours.setValue(hour);
        minutes.setValue(minute);
        this.updateDisplay();
    }

    /** Returns String in format XX:XX
     *
     * @return formatted String
     */
    public String getTime(){
        return displayString;
    }

    /** Formats string from values to format XX:XX
     */
   private void updateDisplay(){
        this.displayString = hours.getDisplayValue() + ":" + minutes.getDisplayValue();
    }

}

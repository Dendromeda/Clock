
public class AlarmClock extends Clock{
    private String alarm;
    private boolean isOn;

    /** Constucts AlarmClock with time set to 00:00.
     */
    public AlarmClock(){
        super();
    }

    /**
     * Constructs AlarmClock with time set to argument values.
     * @param hour hour for clock to be set to
     * @param minute minute for clock to be set to
     */
    public AlarmClock(int hour, int minute){
        super(hour, minute);
    }

    /** Sets alarm to given values.
     * @param hour Hour for alarm to be set to
     * @param minute Minute for alarm to be set to
     */
    public void setAlarm(int hour, int minute){
        alarm = Integer.toString(hour) + ":" + Integer.toString(minute);
        this.turnOn();
    }

    /** Checks if alarm is triggered.
     * @return boolean, true if alarm triggered
     */
    public boolean isTriggered(){
        return isOn && getTime().equals(alarm);
    }

    /** Turns alarm on
     */
    public void turnOn(){
        this.isOn = true;
    }

    /** Turns alarm off
     */
    public void turnOff(){
        this.isOn = false;
    }

    private void checkAlarm(){
        if (isOn){
            if (this.isTriggered()) {
                System.out.println("alarm");
            }
        }
    }

    /** Sets time to given values and checks if this makes alarm trigger
     *
     * @param hour hour to set clock to
     * @param minute minute to set clock to
     */

    @Override
    public void setTime(int hour, int minute){
        super.setTime(hour, minute);
        checkAlarm();
    }

    /** Ticks time and checks , prints "alarm" if alarm is on and is triggered.
     *
     */
    @Override
    public void timeTick(){
        super.timeTick();
        checkAlarm();
    }
}

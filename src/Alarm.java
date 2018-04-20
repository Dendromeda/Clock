public class Alarm {
    public static void main(String[] args) {
        AlarmClock clk = new AlarmClock();
        clk.setAlarm(13, 37);
        for (int i = 0; i < 1441; i++){
            System.out.println(clk.getTime());
            clk.timeTick();
        }

    }
}



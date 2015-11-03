package stuff;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by voldem on 03.11.2015.
 */
public class Time {

    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy   HH:mm:ss");
    Calendar calendar = new GregorianCalendar();
    String time;

    public String getCurrentTime() {
        return time = format.format(calendar.getTime());
    }
}

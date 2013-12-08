import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {

	Date d = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

	public String TimeNow() {
		return ("[" + sdf.format(d) + "]");
	}

}

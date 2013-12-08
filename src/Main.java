import java.util.Timer;

public class Main {

	public static void main(String[] args) {

		Timer timer = new Timer();
		timer.schedule(new TimerTaskTest(), 0, Integer.parseInt("10000"));
	}

}

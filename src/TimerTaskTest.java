import java.util.TimerTask;

public class TimerTaskTest extends TimerTask {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Execute exe = new Execute();
		try {
			exe.executeByInstruction("deck_port");
			Thread.currentThread().sleep(10000);
			exe.executeByInstruction("result");
			Thread.currentThread().sleep(10000);
			exe.executeByInstruction("charge");
			Thread.currentThread().sleep(10000);
			exe.executeByInstruction("misson");
			Thread.currentThread().sleep(
					Integer.parseInt(XMLReader.loadconfig().time));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
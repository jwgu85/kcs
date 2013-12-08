import java.util.TimerTask;

public class TimerTaskTest extends TimerTask {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Execute exe = new Execute();
		exe.executeByInstruction("deck_port");
		try {
			Thread.currentThread().sleep(10000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		exe.executeByInstruction("result");
		try {
			Thread.currentThread().sleep(10000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		exe.executeByInstruction("charge");
		try {
			Thread.currentThread().sleep(10000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		exe.executeByInstruction("misson");
		try {
			Thread.currentThread().sleep(Integer.parseInt(XMLReader.loadconfig().time));
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
}
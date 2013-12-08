import static org.junit.Assert.*;

import org.junit.Test;

public class TestRun {

	Execute exe = new Execute();

	@Test
	public void test() throws InterruptedException {
		exe.executeByInstruction("deck_port");
	}

}

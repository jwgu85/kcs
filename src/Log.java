import java.util.Map;

public class Log {

	public static void writeRequest(String debug, String time, String type,
			Map m) {

		if (XMLReader.loadconfig().debug.equals("1")) {
			WriteStreamAppend.method1("action.log", time + "  " + "type:"
					+ type + "  " + m + "\r\n");
		}

	}

	public static void writeResponse(String debug, String time, Map m,
			String content) {

		if (XMLReader.loadconfig().debug.equals("1")) {
			WriteStreamAppend.method1("action.log", time + "  " + content);
		}

	}

}

import java.io.File;
import java.util.Iterator;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 
 * @author Martin3000
 * 
 */
public class XMLReader {
	// 配置文件名
	private static String filename = "conf.xml";
	private static Config config;

	/**
	 *
	 * 
	 * @return
	 */
	public static Config loadconfig() {
		if (config == null)
			config = getconfig();
		return config;
	}

	private static Config getconfig() {
		Config config = new Config();
		try {
			File f = new File(filename);
			if (!f.exists()) {
				System.out.println("找不到配置文件");
				System.exit(1);
			}
			SAXReader reader = new SAXReader();
			Document doc;
			doc = reader.read(f);
			Element root = doc.getRootElement();
			Element data;
			Iterator<?> itr = root.elementIterator("VALUE");
			data = (Element) itr.next();

			config.api_token = data.elementText("api_token").trim();
			config.api_deck_id = data.elementText("api_deck_id").trim();
			config.api_mission_id = data.elementText("api_mission_id").trim();
			config.time = data.elementText("time").trim();
			config.ip=data.elementText("ip").trim();
			config.debug=data.elementText("debug").trim();

		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}
		return config;

	}
}

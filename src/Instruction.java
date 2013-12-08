import java.util.HashMap;
import java.util.Map;

public class Instruction {

	Map<String, String> map = new HashMap<>();

	public Instruction() {
		map.clear();
		map.put("api_verno", "1");
		map.put("api_token", XMLReader.loadconfig().getApi_token());
	}

	// 補給
	public Map<String, String> charge() {
		map.put("api_kind", "3");
		map.put("api_id_items", Execute.api_flagship);
		return map;
	}

	// 任务
	public Map<String, String> misson() {
		map.put("api_deck_id", XMLReader.loadconfig().getApi_deck_id());
		map.put("api_mission_id", XMLReader.loadconfig().getApi_mission_id());
		return map;
	}

	// 结果
	public Map<String, String> result() {
		map.put("api_deck_id", XMLReader.loadconfig().getApi_deck_id());
		return map;
	}

	// 返航
	public Map<String, String> deck_port() {
		return map;
	}

	// 刷新
	public Map<String, String> logincheck() {
		return map;
	}

}

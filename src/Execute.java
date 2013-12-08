import java.util.HashMap;
import java.util.Map;

public class Execute {

	String res = null;
	static String api_flagship;
	Process p = new Process();

	public void executeByInstruction(String i) throws InterruptedException {
		try {
			HttpRequester request = new HttpRequester();
			Instruction instruction = new Instruction();
			Map<String, String> map = new HashMap<>();
			HttpRespons response = null;

			Map<String, String> headers = new HashMap<String, String>();
			headers.put("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; rv:25.0) Gecko/20100101 Firefox/25.0");
			headers.put("Referer", "http://" + XMLReader.loadconfig().ip
					+ "/kcs/port.swf?version=1.3.9");

			Time time = new Time();

			switch (i) {

			case ("misson"):
				map = instruction.misson();
				System.out.print(time.TimeNow() + "开始远征，编号："
						+ XMLReader.loadconfig().api_mission_id);
				response = request.sendPost("http://"
						+ XMLReader.loadconfig().ip
						+ "/kcsapi/api_req_mission/start", map, headers);
				break;

			case ("deck_port"):
				map = instruction.deck_port();
				System.out.print(time.TimeNow() + "查询第"
						+ XMLReader.loadconfig().api_deck_id + "舰队ID");
				response = request.sendPost("http://"
						+ XMLReader.loadconfig().ip
						+ "/kcsapi/api_get_member/deck_port", map, headers);

				String s = (p.process1(response.getContent()));
				api_flagship = p.Deck_port(s);// 获取当前舰队舰娘ID

				break;

			case ("result"):
				map = instruction.result();
				System.out.print(time.TimeNow() + "返航结果");
				response = request.sendPost("http://"
						+ XMLReader.loadconfig().ip
						+ "/kcsapi/api_req_mission/result", map, headers);
				break;

			case ("charge"):
				map = instruction.charge();
				System.out.print(time.TimeNow() + "是否出击中");
				response = request.sendPost("http://"
						+ XMLReader.loadconfig().ip
						+ "/kcsapi/api_req_hokyu/charge", map, headers);
				break;

			case ("logincheck"):
				map = instruction.result();
				System.out.print(new Time().TimeNow() + "刷新疲劳");
				response = request.sendPost("http://"
						+ XMLReader.loadconfig().ip
						+ "/kcsapi/api_auth_member/logincheck", map, headers);
				break;

			}

			Log.writeRequest(XMLReader.loadconfig().debug, time.TimeNow(), i,
					map);
			Log.writeResponse(XMLReader.loadconfig().debug,
					new Time().TimeNow(), map, response.getContent());

			String s = (p.process1(response.getContent()));
			System.out.println("…………" + p.process2(s));

			// 判断补给是否成功
			if (i.equals("charge")) {
				if (p.process3(response.getContent())) {
					System.out.println(new Time().TimeNow() + "未出击，完成補給");
					Thread.currentThread().sleep(1000);
					executeByInstruction("logincheck");
				} else {
					System.out.println(new Time().TimeNow() + "出击中，等待结束");
					Thread.currentThread().sleep(30000);
					executeByInstruction(i);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			WriteStreamAppend.method1("action.log", e.getMessage() + "\r\n");
			Thread.currentThread().sleep(30000);
			executeByInstruction(i);
		}
	}
}

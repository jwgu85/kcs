import java.util.HashMap;
import java.util.Map;

public class Execute {

	String res = null;
	static String api_flagship;
	Process p = new Process();

	public void executeByInstruction(String i) {
		try {
			HttpRequester request = new HttpRequester();
			Instruction instruction = new Instruction();
			Map<String, String> map = new HashMap<>();
			HttpRespons response = null;

			Map<String, String> headers = new HashMap<String, String>();
			headers.put("Referer",
					"http://"+XMLReader.loadconfig().ip+"/kcs/port.swf?version=1.3.9");

			Time time = new Time();

			switch (i) {

			case ("charge"):
				map = instruction.charge();
				System.out.println(time.TimeNow() + "補給→第"
						+ XMLReader.loadconfig().api_deck_id + "舰队");
				response = request.sendPost(
						"http://"+XMLReader.loadconfig().ip+"/kcsapi/api_req_hokyu/charge", map,
						headers);
				break;

			case ("misson"):
				map = instruction.misson();
				System.out.println(time.TimeNow() + "任务编号："
						+ XMLReader.loadconfig().api_mission_id + "（第"
						+ XMLReader.loadconfig().api_deck_id + "舰队）");
				response = request.sendPost(
						"http://"+XMLReader.loadconfig().ip+"/kcsapi/api_req_mission/start", map,
						headers);
				break;

			case ("deck_port"):
				map = instruction.deck_port();
				System.out.println(time.TimeNow() + "返航→第"
						+ XMLReader.loadconfig().api_deck_id + "舰队");
				response = request.sendPost(
						"http://"+XMLReader.loadconfig().ip+"/kcsapi/api_get_member/deck_port",
						map, headers);
				
				Process p = new Process();
				String s = (p.process1(response.getContent()));
				api_flagship = p.Deck_port(s);//获取当前舰队舰娘ID

				break;

			case ("result"):
				map = instruction.result();
				System.out.println(time.TimeNow() + "结果→第"
						+ XMLReader.loadconfig().api_deck_id + "舰队");
				response = request.sendPost(
						"http://"+XMLReader.loadconfig().ip+"/kcsapi/api_req_mission/result",
						map, headers);
				break;

			}
			
			//写log
			if(XMLReader.loadconfig().debug.equals("1")){
				WriteStreamAppend.method1("action.log", time.TimeNow()+"  "+"type:"+i+"  "+map+"\r\n"+
						new Time().TimeNow()+"  "+response.getContent()); 
			}
			
			String s = (p.process1(response.getContent()));
			System.out.println(new Time().TimeNow() + p.process2(s));
			
			//判断补给是否成功
			if(i.equals("charge")){
				if(!(p.process3(response.getContent()))){
					Thread.currentThread().sleep(30000);
					executeByInstruction(i);
				}				
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			WriteStreamAppend.method1("action.log", e.getMessage()+"\r\n");
		}
	}
}

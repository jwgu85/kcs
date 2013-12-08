import JavaBean.Misson;
import com.google.gson.Gson;

public class Process {

	/** 
	  *@param s 服务器返回报文
	  *@return 标准json格式    
	  */    
	public String process1(String s) {
		String a[] = s.split("=");
		return a[1];
	}
	
	/** 
	  *@param s 标准json格式
	  *@return 成功或失败    
	  */
	public String process2(String s) {
		int i = s.indexOf("\"api_result\":1,");
		if (i >= 1)
			return ("成功");
		else {
			Gson gson = new Gson();
			Misson m = gson.fromJson(s, Misson.class);
			return m.getApi_result_msg();
		}
	}	
	
	/** 
	  *@param s 标准json格式
	  *@return true或false
	  */
	public boolean process3(String s) {
		int i = s.indexOf("\"api_result\":1,");
		if (i >= 1)
			return true;
		else 
			return false;
	}	
	
	/** 
	  *@param s 标准json格式
	  *@return 舰娘ID    
	  */
	public String Deck_port(String s) {
		
		String a[] = s.split("\"api_id\":"+XMLReader.loadconfig().api_deck_id);		
		String b[] =a[1].split("\"api_ship\":");		
		String c;
		if (b[1].indexOf("-1")>=0)
			c = b[1].substring(1, (b[1].indexOf(",-1")));		
		else
			c = b[1].substring(1, (b[1].indexOf("]")));		
		return c;
	}
	
}

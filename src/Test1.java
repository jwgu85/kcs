import java.io.File;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.LinkedList;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import JavaBean.Charge;
import JavaBean.Charge_api_data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Test1 {

		public static void main(String[] args) {

//			String jsonData = "{\"api_data\":{\"api_ship\":[{\"api_id\":27,\"api_fuel\":25,\"api_bull\":25,\"api_onslot\":[0,0,0,0,0]},{\"api_id\":23,\"api_fuel\":15,\"api_bull\":20,\"api_onslot\":[0,0,0,0,0]},{\"api_id\":30,\"api_fuel\":15,\"api_bull\":15,\"api_onslot\":[0,0,0,0,0]},{\"api_id\":3,\"api_fuel\":15,\"api_bull\":20,\"api_onslot\":[0,0,0,0,0]}],\"api_material\":[1224,2168,1807,1429],\"api_use_bou\":1}}";
//			        
//			Charge_api_data api_data = new Charge_api_data();
//						Gson gson = new Gson();
//						api_data = gson.
//			
			
			
//			Type listType = new TypeToken<LinkedList<User>>(){}.getType();
//			       
//			        LinkedList<User> users = gson.fromJson(jsonData, listType);
//			        for (Iterator iterator = users.iterator(); iterator.hasNext();) {
//			            User user = (User) iterator.next();
//			            System.out.println("name--->" + user.getName());
//			            System.out.println("age---->" + user.getAge());
			
			Execute exe = new Execute();
			exe.executeByInstruction("charge");
			
		}
}


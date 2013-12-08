import com.google.gson.Gson;

import JavaBean.Charge;
import JavaBean.Deck_port;
import JavaBean.Misson;

public class JsonHelper {

	Gson gson = new Gson();

	public Misson misson(String m) {
		Misson misson = gson.fromJson(m, Misson.class);
		return misson;
	}

	public Charge charge(String c) {
		Charge charge = gson.fromJson(c, Charge.class);
		return charge;
	}

	public Deck_port deck_port(String d) {
		Deck_port deck_port = gson.fromJson(d, Deck_port.class);
		return deck_port;
	}

}

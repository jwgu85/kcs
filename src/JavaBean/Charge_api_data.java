package JavaBean;

import java.util.List;
import java.util.Map;

public class Charge_api_data {

	private String api_use_bou;
	private List<String> api_material;
	private Map<String, String> api_ship;

	public String getApi_use_bou() {
		return api_use_bou;
	}

	public void setApi_use_bou(String api_use_bou) {
		this.api_use_bou = api_use_bou;
	}

	public List<String> getApi_material() {
		return api_material;
	}

	public void setApi_material(List<String> api_material) {
		this.api_material = api_material;
	}

	public Map<String, String> getApi_ship() {
		return api_ship;
	}

	public void setApi_ship(Map<String, String> api_ship) {
		this.api_ship = api_ship;
	}

}

package config;

import java.util.HashMap;
import java.util.Map;

public class ActionMappingConfig {

	private Map<String, ActionConfig> map = new HashMap<String, ActionConfig>();

	public void addAction(ActionConfig action){
		map.put(action.getPath(), action);
	}
	
	public ActionConfig findAction(String path){
		return map.get(path);
	}
	
	public Map<String, ActionConfig> getMap() {
		return map;
	}

	public void setMap(Map<String, ActionConfig> map) {
		this.map = map;
	}

	public ActionMappingConfig() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ActionMappingConfig [map=" + map + "]";
	}
	
	
	
	
}

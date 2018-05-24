package config;

import java.util.HashMap;
import java.util.Map;

public class ActionConfig {

	private String path;
	private String type;
	private String parameter;
	private Map<String, ForwardConfig> map = new HashMap<String, ForwardConfig>();
	
	public void addForward(ForwardConfig forward){
		map.put(forward.getName(), forward);
	}
	
	public ForwardConfig findForward(String name){
		return map.get(name);
	}
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getParameter() {
		return parameter;
	}
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	public Map<String, ForwardConfig> getMap() {
		return map;
	}
	public void setMap(Map<String, ForwardConfig> map) {
		this.map = map;
	}
	public ActionConfig() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ActionConfig [path=" + path + ", type=" + type + ", parameter="
				+ parameter + ", map=" + map + "]";
	}
	
}

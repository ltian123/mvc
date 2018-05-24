package test;


import org.apache.commons.digester.Digester;
import org.apache.commons.digester.xmlrules.DigesterLoader;

import config.ActionMappingConfig;


public class DigesterParse {

	public static void main(String[] args) {
		//加载配置文件(rule.xml),并获取解析器
		Digester digester = DigesterLoader.createDigester(DigesterParse.class.getClassLoader().getResource("config/rule.xml"));
		
		//准备一个空的根元素对象
		ActionMappingConfig actionMapping = new ActionMappingConfig();
		
		digester.push(actionMapping);
		
		try {
			//解析
			digester.parse(DigesterParse.class.getClassLoader().getResourceAsStream("action.xml"));
			System.out.println(actionMapping);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
		
	}
}

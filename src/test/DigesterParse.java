package test;


import org.apache.commons.digester.Digester;
import org.apache.commons.digester.xmlrules.DigesterLoader;

import config.ActionMappingConfig;


public class DigesterParse {

	public static void main(String[] args) {
		//���������ļ�(rule.xml),����ȡ������
		Digester digester = DigesterLoader.createDigester(DigesterParse.class.getClassLoader().getResource("config/rule.xml"));
		
		//׼��һ���յĸ�Ԫ�ض���
		ActionMappingConfig actionMapping = new ActionMappingConfig();
		
		digester.push(actionMapping);
		
		try {
			//����
			digester.parse(DigesterParse.class.getClassLoader().getResourceAsStream("action.xml"));
			System.out.println(actionMapping);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
		
	}
}

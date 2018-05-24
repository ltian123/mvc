package servlet;


import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.xmlrules.DigesterLoader;


import config.ActionConfig;
import config.ActionMappingConfig;
import config.ForwardConfig;

public class ActionServlet extends HttpServlet {

	private ActionMappingConfig mappingConfig;
	
	private Map<String, Object> actions;
	
	@Override
	public void init() throws ServletException {
		actions = new HashMap<String, Object>();
		
		//���������ļ�,����ȡ������
		Digester digester = DigesterLoader.createDigester(ActionServlet.class.getClassLoader().getResource("config/rule.xml"));
		
		//׼��һ���յĶ�����
		mappingConfig = new ActionMappingConfig();
		
		//�����󽻸�������
		digester.push(mappingConfig);
		
		try {
			String config = getServletConfig().getInitParameter("config");
			
			digester.parse(ActionServlet.class.getClassLoader().getResourceAsStream(config));
		} catch (Exception e) {
			throw new ServletException("�����ļ�ʧ��",e);
		} 
		
		
		
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		System.out.println("mappingConfig:"+mappingConfig);
		
		//��ȡurl-pattern������
		String path = request.getServletPath();
//		System.out.println("path:"+path);
		
		//��ȡ.do,����ǰ�沿��
		path = path.substring(0, path.lastIndexOf(".do"));
//		System.out.println("��ȡ���path:"+path);
		
		//����path,�ҵ���Ӧ��action����
		ActionConfig actionConfig = mappingConfig.findAction(path);
//		System.out.println(actionConfig);
		//�����path������,����
		if(actionConfig==null){
			System.out.println(path+"������");
			return;
		}
		
		//����actionConfig�е�type�ҵ���Ӧ����
		//���Ҹ���parameter�ҵ���Ӧ�ķ���
		//��Action�������ɵ�����,���Ч��
		try {
			Class actionClass = Class.forName(actionConfig.getType());
			Object action = actions.get(actionConfig.getType());
			if(action == null){
				action = actionClass.newInstance();
				actions.put(actionConfig.getType(), action);
			}
//			System.out.println("action:"+action);
			
//			System.out.println(actionConfig.getParameter());
			
			//��ȡ���ж�Ӧ�ķ���
			//getMethod(String name, Class<?>... parameterTypes) 
			//name��ʾ������
			//parameterTypes��ʾ�β��б�
			Method method = actionClass.getMethod(actionConfig.getParameter(),HttpServletRequest.class,HttpServletResponse.class);
			
//			System.out.println(method);
			//����parameter����
			//invoke�����ķ���ֵ���ǵײ㷽���ķ���ֵ
			String result = (String)method.invoke(action, request,response);
//			
//			System.out.println("result:"+result);
			
			if(result==null){
				return;
			}
			
			ForwardConfig forwardConfig = actionConfig.findForward(result);
			
			System.out.println("forwardConfig:"+forwardConfig);
			
			if(forwardConfig == null){
				System.out.println(result+"������");
				return;
			}
			
			//����redirect�ж���ת�������ض���
			if(forwardConfig.isRedirect()){
				//�ض���
				response.sendRedirect(request.getContextPath()+forwardConfig.getPath());
			}else{
				//ת��
				request.getRequestDispatcher(forwardConfig.getPath()).forward(request, response);
			}
			
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		
		
		
		
		
		
		
		
		
	}
}

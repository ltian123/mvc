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
		
		//加载配置文件,并获取解析器
		Digester digester = DigesterLoader.createDigester(ActionServlet.class.getClassLoader().getResource("config/rule.xml"));
		
		//准备一个空的对象存放
		mappingConfig = new ActionMappingConfig();
		
		//将对象交给解析器
		digester.push(mappingConfig);
		
		try {
			String config = getServletConfig().getInitParameter("config");
			
			digester.parse(ActionServlet.class.getClassLoader().getResourceAsStream(config));
		} catch (Exception e) {
			throw new ServletException("解析文件失败",e);
		} 
		
		
		
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		System.out.println("mappingConfig:"+mappingConfig);
		
		//获取url-pattern请求名
		String path = request.getServletPath();
//		System.out.println("path:"+path);
		
		//截取.do,保留前面部分
		path = path.substring(0, path.lastIndexOf(".do"));
//		System.out.println("截取后的path:"+path);
		
		//根据path,找到对应的action配置
		ActionConfig actionConfig = mappingConfig.findAction(path);
//		System.out.println(actionConfig);
		//如果该path不存在,结束
		if(actionConfig==null){
			System.out.println(path+"不存在");
			return;
		}
		
		//根据actionConfig中的type找到对应的类
		//并且根据parameter找到对应的方法
		//将Action对象做成单例的,提高效率
		try {
			Class actionClass = Class.forName(actionConfig.getType());
			Object action = actions.get(actionConfig.getType());
			if(action == null){
				action = actionClass.newInstance();
				actions.put(actionConfig.getType(), action);
			}
//			System.out.println("action:"+action);
			
//			System.out.println(actionConfig.getParameter());
			
			//获取类中对应的方法
			//getMethod(String name, Class<?>... parameterTypes) 
			//name表示方法名
			//parameterTypes表示形参列表
			Method method = actionClass.getMethod(actionConfig.getParameter(),HttpServletRequest.class,HttpServletResponse.class);
			
//			System.out.println(method);
			//调用parameter方法
			//invoke方法的返回值就是底层方法的返回值
			String result = (String)method.invoke(action, request,response);
//			
//			System.out.println("result:"+result);
			
			if(result==null){
				return;
			}
			
			ForwardConfig forwardConfig = actionConfig.findForward(result);
			
			System.out.println("forwardConfig:"+forwardConfig);
			
			if(forwardConfig == null){
				System.out.println(result+"不存在");
				return;
			}
			
			//根据redirect判断是转发还是重定向
			if(forwardConfig.isRedirect()){
				//重定向
				response.sendRedirect(request.getContextPath()+forwardConfig.getPath());
			}else{
				//转发
				request.getRequestDispatcher(forwardConfig.getPath()).forward(request, response);
			}
			
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		
		
		
		
		
		
		
		
		
	}
}

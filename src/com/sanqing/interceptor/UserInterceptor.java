package com.sanqing.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class UserInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext context=invocation.getInvocationContext();
		Map session=context.getContext().getSession();
		String  username=(String) session.get("username");
		if(username==null||"".equals(username)){//判断用户名的非法性
			return Action.LOGIN;
		}else{
			return invocation.invoke(); //进行下一步，没有拦截
		}
	}

}

package com.sanqing.action;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sanqing.po.BlogInfo;
import com.sanqing.service.BlogInfoService;

/**
 * Created by Administrator on 2017/7/3.
 */
public class GetBlogInfo extends ActionSupport {
	private BlogInfoService blogInfoService;

	public BlogInfoService getBlogInfoService() {
		return blogInfoService;
	}

	public void setBlogInfoService(BlogInfoService blogInfoService) {
		this.blogInfoService = blogInfoService;
	}
	
	public String execute() throws Exception{
		//获得usrname
		Map session = ActionContext.getContext().getSession();
		String username = (String) session.get("username");
				
		//通过业务逻辑组件来查询
		BlogInfo blogInfo  = blogInfoService.getBlogInfo(username);
				
		if(blogInfo !=null){
			session.put("blogtitle", blogInfo.getBlogtitle());
			session.put("idiograph", blogInfo.getIdiograph());
		}
		return SUCCESS;
	}
}

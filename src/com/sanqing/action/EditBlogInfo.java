package com.sanqing.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sanqing.po.BlogInfo;
import com.sanqing.service.BlogInfoService;

/**
 * Created by Administrator on 2017/7/3.
 */
public class EditBlogInfo extends ActionSupport {
	private String blogtitle;
	private String idiograph;
	private BlogInfoService blogInfoService;
	public String getBlogtitle() {
		return blogtitle;
	}
	public void setBlogtitle(String blogtitle) {
		this.blogtitle = blogtitle;
	}
	public String getIdiograph() {
		return idiograph;
	}
	public void setIdiograph(String idiograph) {
		this.idiograph = idiograph;
	}
	public BlogInfoService getBlogInfoService() {
		return blogInfoService;
	}
	public void setBlogInfoService(BlogInfoService blogInfoService) {
		this.blogInfoService = blogInfoService;
	}
	
	public String execute() throws Exception {
//		//���request
//		HttpServletRequest request = ServletActionContext.getRequest();
//		//���session
//		HttpSession session =request.getSession();
//		//���username
//		String username = (String) session.getAttribute("username");
		
		Map session = ActionContext.getContext().getSession();
		String username = (String) session.get("username");
		
		BlogInfo blogInfo = new BlogInfo();
		//�����û���
		blogInfo.setUsername(username);
		//���ò��ͱ���
		blogInfo.setBlogtitle(blogtitle);
		//���ø���ǩ��
		blogInfo.setIdiograph(idiograph);
		//����ҵ���߼�������������
		blogInfoService.setBlogInfo(blogInfo);
		
		return this.SUCCESS;
	}
}


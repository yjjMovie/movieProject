package org.movie.action;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;

@Controller("indexAction")
public class IndexAction extends ActionSupport{

	/**
	 * 执行的访问首页的方法:
	 */
	public String execute(){
		
		return "index";
	}
	
	
}

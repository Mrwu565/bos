package com.itheima.bos.web.action;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.itheima.bos.domain.Decidedzone;
import com.itheima.bos.service.IDecidedzoneService;
import com.itheima.bos.web.action.base.BaseAction;


/**
 * 定区管理
 * @author zhaoqx
 *
 */
@Controller
@Scope("prototype")
public class DecidedzoneAction extends BaseAction<Decidedzone>{
	//属性驱动，接收多个分区id
	private String[] subareaid;
	public void setSubareaid(String[] subareaid) {
		this.subareaid = subareaid;
	}
	
	@Autowired
	private IDecidedzoneService decidedzoneService;
	
	/**
	 * 添加定区
	 */
	public String add(){
		decidedzoneService.save(model,subareaid);
		return LIST;
	}
	
	/**
	 * 分页查询方法
	 */
	public String pageQuery() throws IOException{
		decidedzoneService.pageQuery(pageBean);
		this.java2Json(pageBean, new String[]{"currentPage","detachedCriteria",
						"pageSize","subareas","decidedzones"});
		return NONE;
	}
	
	
}

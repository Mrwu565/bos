package com.itheima.bos.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.domain.Function;
import com.itheima.bos.service.IFunctionService;
import com.itheima.bos.web.action.base.BaseAction;

@Controller
@Scope("prototype")
public class FunctionAction extends BaseAction<Function> {

    @Autowired
    private IFunctionService functionService;

    public String listajax() {
        List<Function> list = functionService.findAll();
        this.java2Json(list, new String[] { "parentFunction", "roles", "children" });
        return NONE;
    }

    public String add() {
        functionService.save(model);
        return LIST;
    }

    public String pageQuery() {
        String page=model.getPage();
        pageBean.setCurrentPage(Integer.parseInt(page));
        functionService.pageQuery(pageBean);
        this.java2Json(pageBean, new String[] { "parentFunction", "roles", "children" });
        return NONE;
    }
}

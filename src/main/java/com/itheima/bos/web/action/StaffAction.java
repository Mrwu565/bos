package com.itheima.bos.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import com.itheima.bos.domain.Staff;
import com.itheima.bos.service.IStaffService;
import com.itheima.bos.utils.PageBean;
import com.itheima.bos.web.action.base.BaseAction;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * 取派员Atcion
 * @author Administrator
 *
 */
@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff> {
    
    private int page;
    private int rows;
    
    @Autowired
    public IStaffService staffService;
    
    /**
     * 取派员添加
     */
    public String add() {
        staffService.save(model);
        return LIST;
    }
    
    /**
     * 分页查询
     * @return
     * @throws IOException
     */
    @RequiresPermissions("staff-list")
    public String pageQuery() throws IOException {
        staffService.pageQuery(pageBean);
        System.out.println(pageBean);
        this.java2Json(pageBean, new String[]{"decidedzones","currentPage","detachedCriteria","pageSize"});
        return NONE;
    }
    
    /**
     * 取派员添加
     */
    public String edit() {
      //显查询数据库，根据id查询原始数据
        Staff staff = staffService.findById(model.getId());
        //使用页面提交的数据进行覆盖
        staff.setName(model.getName());
        staff.setTelephone(model.getTelephone());
        staff.setHaspda(model.getHaspda());
        staff.setStandard(model.getStandard());
        staff.setStation(model.getStation());
        staffService.update(staff);

        return LIST;
    }
    private String ids;
    /**
     * 批量删除
     * @return
     */
    public String deleteBatch() {
        staffService.deleteBatch(ids);
        return LIST;
    }
    
    /**
     * 查询所有未删除的取派员，返回json
     */
    public String listajax(){
        List<Staff> list = staffService.findListNotDelete();
        this.java2Json(list, new String[]{"decidedzones"});
        return NONE;
    }
    
    

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}

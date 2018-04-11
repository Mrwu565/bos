package com.itheima.bos.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.wstx.util.StringUtil;
import com.itheima.bos.dao.IStaffDao;
import com.itheima.bos.domain.Staff;
import com.itheima.bos.service.IStaffService;
import com.itheima.bos.utils.PageBean;

@Service
@Transactional
public class IStaffServiceImpl implements IStaffService{
    
    @Autowired
    public IStaffDao staffDao;
    
    public void save(Staff model) {
        staffDao.save(model);
    }

    public void pageQuery(PageBean pageBean) {
        staffDao.pageQuery(pageBean);
    }

    public void deleteBatch(String ids) {
        if(StringUtils.isNotBlank(ids)) {
            String[] id=ids.split(",");
            for (String i : id) {
                staffDao.executeUpdate("staff.delete", i);
            }
        } 
    }

    public Staff findById(String id) {
        return staffDao.findById(id);
    }

    public void update(Staff staff) {
        staffDao.update(staff);
    }

}

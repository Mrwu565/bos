package com.itheima.bos.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.crm.Customer;
import com.itheima.bos.crm.ICustomerService;
import com.itheima.bos.domain.Noticebill;
import com.itheima.bos.service.INoticebillService;
import com.itheima.bos.web.action.base.BaseAction;
@Controller
@Scope("prototype")
public class NoticebillAction extends BaseAction<Noticebill> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    @Autowired
    private ICustomerService customerService;
                  
    public String findCustomerByTelephone() {
        String telephone=model.getTelephone();
        Customer findCustomerByTelephone = customerService.findCustomerByTelephone(telephone);
        this.java2Json(findCustomerByTelephone, new String[] {});
        return NONE;
        }
    
    @Autowired
    private INoticebillService noticebillService;
    
    public String add() {
        noticebillService.save(model);
        
        return "noticebill_add";}
    
}

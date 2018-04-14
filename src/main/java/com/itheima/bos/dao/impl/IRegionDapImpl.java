package com.itheima.bos.dao.impl;

import java.io.Serializable;
import java.util.List;



import com.itheima.bos.dao.IRegionDao;
import com.itheima.bos.dao.base.impl.BaseDaoImpl;
import com.itheima.bos.domain.Region;


public class IRegionDapImpl extends BaseDaoImpl<Region> implements IRegionDao {

    public List<Region> findListByQ(String q) {
        String hql = "FROM Region r WHERE r.shortcode LIKE ? "
                + " OR r.citycode LIKE ? OR r.province LIKE ? "
                + "OR r.city LIKE ? OR r.district LIKE ?";
        List<Region> list = (List<Region>) this.getHibernateTemplate().find(hql, "%"+q+"%","%"+q+"%","%"+q+"%","%"+q+"%","%"+q+"%");
        return list;
    }

   
}

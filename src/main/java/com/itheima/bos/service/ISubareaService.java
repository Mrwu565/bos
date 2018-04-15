package com.itheima.bos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itheima.bos.domain.Subarea;
import com.itheima.bos.utils.PageBean;

public interface ISubareaService {

    void save(Subarea model);

    void pageQuery(PageBean pageBean);

    List<Subarea> findAll();

    List<Subarea> findListNotAssociation();

}

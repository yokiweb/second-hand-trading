package com.yaoyao.shop.server.service.impl;

import com.yaoyao.shop.server.dao.AdminDao;
import com.yaoyao.shop.server.model.AdminModel;
import com.yaoyao.shop.server.service.AdminService;
import com.yaoyao.shop.server.vo.PageVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yoki
 * @create 2021-02-07  22:00
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminDao adminDao;

    public AdminModel login(String accountNumber, String adminPassword){
        return adminDao.login(accountNumber,adminPassword);
    }

    public PageVo<AdminModel> getAdminList(int page, int nums){
        List<AdminModel> list=adminDao.getList((page-1)*nums,nums);
        int count=adminDao.getCount();
        return new PageVo<>(list,count);
    }

    public boolean addAdmin(AdminModel adminModel){
        return adminDao.insert(adminModel)==1;
    }
}

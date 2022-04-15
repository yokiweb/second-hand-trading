package com.yaoyao.shop.server.service;

import com.yaoyao.shop.server.model.AdminModel;
import com.yaoyao.shop.server.vo.PageVo;

/**
 * @author yoki
 * @create 2021-02-07  22:00
 */
public interface AdminService {

    AdminModel login(String accountNumber, String adminPassword);

    PageVo<AdminModel> getAdminList(int page, int nums);

    boolean addAdmin(AdminModel adminModel);


}

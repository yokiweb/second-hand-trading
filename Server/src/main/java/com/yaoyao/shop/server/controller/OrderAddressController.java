package com.yaoyao.shop.server.controller;

import com.yaoyao.shop.server.enums.ErrorMsg;
import com.yaoyao.shop.server.model.OrderAddressModel;
import com.yaoyao.shop.server.service.OrderAddressService;
import com.yaoyao.shop.server.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author yoki
 * @create 2020-12-26  16:23
 */
@RestController
@RequestMapping("/order-address")
public class OrderAddressController {

    @Autowired
    private OrderAddressService orderAddressService;

    @PostMapping("/add")
    public ResultVo addOrderAddress(@CookieValue("shUserId")
                                        @NotNull(message = "登录异常 请重新登录")
                                        @NotEmpty(message = "登录异常 请重新登录") String shUserId,
                                    @RequestBody OrderAddressModel orderAddressModel){
        return ResultVo.success(orderAddressService.addOrderAddress(orderAddressModel));
    }

    @PostMapping("/update")
    public ResultVo updateOrderAddress(@CookieValue("shUserId")
                                       @NotNull(message = "登录异常 请重新登录")
                                       @NotEmpty(message = "登录异常 请重新登录") String shUserId,
                                       @RequestBody OrderAddressModel orderAddressModel){
        if(orderAddressService.updateOrderAddress(orderAddressModel)){
            return ResultVo.success(orderAddressModel);
        }
        return ResultVo.fail(ErrorMsg.SYSTEM_ERROR);
    }

    @GetMapping("/info")
    public ResultVo getOrderAddress(@CookieValue("shUserId")
                                    @NotNull(message = "登录异常 请重新登录")
                                    @NotEmpty(message = "登录异常 请重新登录") String shUserId,
                                    @RequestParam Long orderId){
        return ResultVo.success(orderAddressService.getOrderAddress(orderId));
    }
}

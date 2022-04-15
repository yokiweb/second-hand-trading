package com.yaoyao.shop.server.controller;

import com.yaoyao.shop.server.enums.ErrorMsg;
import com.yaoyao.shop.server.model.AddressModel;
import com.yaoyao.shop.server.service.AddressService;
import com.yaoyao.shop.server.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author yoki
 * @create 2020-12-21  8:55
 */
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/info")
    public  ResultVo getAddress(@CookieValue("shUserId")
                                    @NotNull(message = "登录异常，请重新登录")
                                    @NotEmpty(message = "登录异常，请重新登录") String shUserId,
                                @RequestParam(value = "id",required = false) Long id){
        if(null==id){
            return ResultVo.success(addressService.getAddressByUser(Long.valueOf(shUserId)));
        }else {
            return ResultVo.success(addressService.getAddressById(id,Long.valueOf(shUserId)));
        }
    }

    @PostMapping("/add")
    public ResultVo addAddress(@CookieValue("shUserId")
                                   @NotNull(message = "登录异常 请重新登录")
                                   @NotEmpty(message = "登录异常 请重新登录") String shUserId,
                               @RequestBody AddressModel addressModel){
        addressModel.setUserId(Long.valueOf(shUserId));
        if(addressService.addAddress(addressModel)){
            return ResultVo.success(addressModel);
        }
        return ResultVo.fail(ErrorMsg.SYSTEM_ERROR);
    }

    @PostMapping("/update")
    public ResultVo updateAddress(@CookieValue("shUserId")
                               @NotNull(message = "登录异常 请重新登录")
                               @NotEmpty(message = "登录异常 请重新登录") String shUserId,
                               @RequestBody AddressModel addressModel){
        addressModel.setUserId(Long.valueOf(shUserId));
        if(addressService.updateAddress(addressModel)){
            return ResultVo.success();
        }
        return ResultVo.fail(ErrorMsg.SYSTEM_ERROR);
    }

    @PostMapping("/delete")
    public ResultVo deleteAddress(@CookieValue("shUserId")
                                  @NotNull(message = "登录异常 请重新登录")
                                  @NotEmpty(message = "登录异常 请重新登录") String shUserId,
                                  @RequestBody AddressModel addressModel){
        addressModel.setUserId(Long.valueOf(shUserId));
        if(addressService.deleteAddress(addressModel)){
            return ResultVo.success();
        }
        return ResultVo.fail(ErrorMsg.SYSTEM_ERROR);
    }
}

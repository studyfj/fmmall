package com.itcast.fmmall.controller;

import com.itcast.ResultVO;
import com.itcast.constant.SystemConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fengjun
 * @version 1.0
 * @Email fengjun3@asiainfo.com
 * @date 2022/5/20 16:40
 * @Description 致敬大师，致敬未来的自己
 */
@RequestMapping("/shopcart")
@CrossOrigin
@RestController
@Api(value = "进行购物车的控制器", tags = "购物车相关接口")
public class ShopCartController {

    @ApiOperation("购物车列表接口")
    @ApiImplicitParam(dataType = "string", name = "token", value = "token令牌", required = true)
    @GetMapping("/list")
    public ResultVO listCarts(String token) {
        return new ResultVO(SystemConstants.SUCCESS_CODE, "success", null);
    }

}

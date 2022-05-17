package com.itcast.fmmall.controller;

import com.itcast.ResultVO;
import com.itcast.fmmall.pojo.Users;
import com.itcast.fmmall.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author fengjun
 * @version 1.0
 * @Email fengjun3@asiainfo.com
 * @date 2022/5/14 18:08
 * @Description 致敬大师，致敬未来的自己
 */
@RestController
@Api(value = "进行用户请求的控制器", tags = "用户管理相关接口")
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    @ApiOperation("用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string", name = "username", value = "用户名", required = true),
            @ApiImplicitParam(dataType = "string", name = "password", value = "密码", required = true)
    })
    public ResultVO login(String username, String password) {
        return userService.checkLogin(username, password);
    }

    @PostMapping("/register")
    @ApiOperation("用户注册接口")
    public ResultVO register(@RequestBody Users user) {
        return userService.userRegister(user.getUsername(), user.getPassword());
    }
}

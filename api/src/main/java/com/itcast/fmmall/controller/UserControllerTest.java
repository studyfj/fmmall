package com.itcast.fmmall.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fengjun
 * @version 1.0
 * @Email fengjun3@asiainfo.com
 * @date 2022/5/12 17:43
 * @Description 致敬大师，致敬未来的自己
 */
@RestController
@RequestMapping("/user")
@Api(value = "实现用户的的查询和注册功能", tags = "用户管理")
public class UserControllerTest {

    //
    //@Resource
    //private UserService userService;
    //
    //@GetMapping("/all")
    //@ApiOperation("进行查询所有用户的信息")
    //public ResultVO all() {
    //    return new ResultVO(200, "成功", userService.queryAll());
    //}
    //
    //@PostMapping("/register")
    //@ApiOperation("注册用户")
    ////@ApiImplicitParams({
    ////        @ApiImplicitParam(dataType = "Integer", name = "id", value = "用户id", required = true),
    ////        @ApiImplicitParam(dataType = "string", name = "username", value = "用户姓名", required = true),
    ////        @ApiImplicitParam(dataType = "string", name = "password", value = "用户密码", required = true)
    ////})
    ////@ApiImplicitParam(name = "用户信息", required = true)
    //public ResultVO register(UserTest user) {
    //    System.out.println("register");
    //    return new ResultVO(10000, "success", null);
    //}
}

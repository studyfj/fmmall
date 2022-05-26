package com.itcast.fmmall.service;

import com.itcast.ResultVO;
import org.springframework.stereotype.Service;

/**
 * @author fengjun
 * @version 1.0
 * @Email fengjun3@asiainfo.com
 * @date 2022/5/14 17:25
 * @Description 致敬大师，致敬未来的自己
 */
public interface UserService {

    /**
     * 用户注册功能
     * @param username 注册的用户名
     * @param password 注册的密码
     * @return 注册是否成功
     */
    public ResultVO userRegister(String username, String password);

    /**
     * 检查登录
     * @param username 登录的用户名
     * @param password 登录的密码
     * @return 登录是否成功
     */
    public ResultVO checkLogin(String username, String password);
}
